/*
 * problem1.c
 *
 * Problem 1:
 * This problem is to write a set of C functions that
 * perform specified operations on files and directories
 * that require determining and using information about
 * files, directories and directory entries.
 *
 */
#include <dirent.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <string.h>

#if defined _WIN32 || defined __CYGWIN__
const char* FILE_NAME = "C:\\Windows\\notepad.exe";
const char* DIR_NAME = "C:\\Windows";
const char PATH_SEPARATOR = '\\';

#else
const char* FILE_NAME = "/usr/include/stdlib.h";
const char* DIR_NAME = "/usr/include";
const char PATH_SEPARATOR = '/';
#endif

/**
 * Returns string representation of a boolean value.
 * @param b boolean
 * @return "true" or "false"
 */
const char* boolToS(bool b) {
    return b ? "true" : "false";
}

/**
 * Creates a file from a directory path and a file name
 * @param dirName the directory path
 * @param fName the file name
 * @param pathName buffer to write the new path
 * @return pointer to the new path
 */
char* makePath(const char* dirName, const char* fName, char* pathName) {
    sprintf(pathName, "%s%c%s", dirName, PATH_SEPARATOR,fName);
    return pathName;
}

//check if given path is a file
bool is_file(const char* path) {
    struct stat buf;
    stat(path, &buf);
    return S_ISREG(buf.st_mode);
}

//check if given path is a directory
bool is_dir(const char* path) {
    struct stat buf;
    stat(path, &buf);
    return S_ISDIR(buf.st_mode);
}

/**
 * Count the directories within the specified directory if
 * it exists, or -1 if not a directory or does not exist.
 * Does not count "." and "..".
 *
 * @param dirName name of directory
 * @return number of sub-directories
 */
long countDirectories(const char* dirName) {
    // your code here
    // hint: get entry type from inode
    // hint: use makePath above to make path
    if (!is_dir(dirName)) {
        return -1;
    }
    int count = -1;
    struct dirent *de;  // Pointer for directory entry
    
    // opendir() returns a pointer of DIR type.
    DIR *dr = opendir(dirName);
    
    // returns -1 if couldn't open directory
    if (dr == NULL){
        printf("Could not open current directory" );
        return -1;
    }
    
    char pathName[100];
    //read directory
    while ((de = readdir(dr)) != NULL){
        char* path =  makePath(dirName, de->d_name, pathName);
        if (is_dir(path)) {
            count++;
        }
    }
    closedir(dr);
    return count;
}

/**
 * Returns the size of a regular file if it exists,
 * or -1 if it is not a regular file or does not exist.
 *
 * @param fname the name of the file
 * @return size of regular file or -1
 */
long fileSize(const char* fname) {
    long size = 0;
    // opening the file in read mode
    FILE* fp = fopen(fname, "r");
    
    // checking if the file exist or not
    if (fp == NULL) {
        printf("File Not Found!\n");
        return -1;
    }
    
    fseek(fp, 0L, SEEK_END);
    
    // calculating the size of the file
    size = ftell(fp);
    
    // closing the file
    fclose(fp);
    
    return size;
}

/**
 * Returns the total size of all the regular files
 * within a specified directory if it exists, or -1
 * if not a directory or does not exist.
 *
 * @param dirName name of directory
 * @return total size of all regular files
 */
long fileSizes(const char* dirName) {
    // your code here
    // hint: get entry type from inode
    // hint: use makePath above to make path
    long size = 0;
    //return -1 if dirName is not a directory
    if (!is_dir(dirName)) {
        return -1;
    }
    struct dirent *de;  // Pointer for directory entry
    
    // opendir() returns a pointer of DIR type.
    DIR *dr = opendir(dirName);
    
    // returns -1 if couldn't open directory
    if (dr == NULL){
        printf("Could not open current directory" );
        return -1;
    }
    
    char pathName[100];
    //read directory
    while ((de = readdir(dr)) != NULL){
        char* path =  makePath(dirName, de->d_name, pathName);
        if (is_file(path)) {
            size += fileSize(path);
        }
    }
    closedir(dr);
    return size;
}

bool compareFiles(FILE *fp1, FILE *fp2){
    // fetching character of two file
    // in two variable ch1 and ch2
    char ch1 = getc(fp1);
    char ch2 = getc(fp2);
    
    // iterate loop till end of file
    while (ch1 != EOF && ch2 != EOF){
        // if fetched data is not equal then return false
        if (ch1 != ch2){
            return false;
        }
        
        // fetching character until end of file
        ch1 = getc(fp1);
        ch2 = getc(fp2);
    }
    
    return true;
}

/**
 * Determines whether the two names refer to the same file
 * or directory. Comparing names is *not* sufficient because
 * the names could be links to the same file or directory.
 *
 * Uses file inodes for comparison.
 *
 * @param fname1 the first file or directory
 * @param fname2 the second file or directory
 * @return true of both files or directories exist and
 * 	are the same one, and false otherwise
 */
bool isSameFile(const char* fname1, const char* fname2) {
    // your code here
    if ((is_dir(fname1) && is_file(fname2)) || (is_file(fname1) && is_dir(fname2))) {
        return false;
    }
    // if both are directories
    if (is_dir(fname1) && is_dir(fname2)) {
        if( strcmp(fname1, fname2) == 0) {
            printf("equal");
        }
    }
    FILE *fp1 = fopen(fname1, "r");
    FILE *fp2 = fopen(fname2, "r");
    
    if (fp1 == NULL || fp2 == NULL){
        return false;
    }
    
    bool res = compareFiles(fp1, fp2);
    
    // closing both file
    fclose(fp1);
    fclose(fp2);
    return res;
}

int main() {
    printf("Start problem 1\n");
    
    // count directories
    long count;
    
    // count directories tests: directory name and file name
    printf("\n");
    count = countDirectories(DIR_NAME);
    printf("countDirectories(%s): %ld\n", DIR_NAME, count);
    count = countDirectories(FILE_NAME);  // expect -1
    printf("countDirectories(%s): %ld  (expect -1)\n", FILE_NAME, count);
    
    // get size of file tests: file name and directory
    printf("\n");
    count = fileSize(FILE_NAME);
    printf("fileSize(%s): %ld\n", FILE_NAME, count);
    count = fileSize(DIR_NAME); // expect -1
    printf("fileSize(%s): %ld  (expect -1)\n", DIR_NAME, count);
    
    // get total size of files tests: directory name and file name
    printf("\n");
    count = fileSizes(DIR_NAME);
    printf("fileSizes(%s): %ld\n", DIR_NAME, count);
    count = fileSizes(FILE_NAME);	// expect -1
    printf("fileSizes(%s): %ld  (expect -1)\n", FILE_NAME, count);
    
    bool b;
    
    // determine same file: files, directories, file and directory
    printf("\n");
    b= isSameFile(FILE_NAME, FILE_NAME);	// expect true
    printf("isSameFile(%s, %s): %s (expect true)\n", FILE_NAME, FILE_NAME, boolToS(b));
    b= isSameFile(DIR_NAME, DIR_NAME);	// expect true
    printf("isSameFile(%s, %s): %s (expect true)\n", DIR_NAME, DIR_NAME, boolToS(b));
    b= isSameFile(FILE_NAME, DIR_NAME);	// expect false
    printf("isSameFile(%s, %s): %s (expect false)\n", FILE_NAME, DIR_NAME, boolToS(b));
    
    return EXIT_SUCCESS;
    
    printf("End problem 1\n");
}
/*************1.c*******************/

/*************3.c*******************/
/*
 * problem3.c
 *
 * Problem 3:
 * This program uses signals to control the state of the program.
 * NOTE: On Windows, this requires CygWin.
 *
 * The loop in the main method loops forever. For each iteration,
 * it sleeps for 2 seconds, then sends a signal to its own signal
 * handler for the value of nextSignal, initially SIGUSR1.
 *
 * Before entering the loop, the main program sets an alarm that
 * will send an SIGALRM signal after 15 seconds.
 *
 * This problem is to create and install handlers for the following
 * signals that will enable the program to operate correctly.  Be
 * sure to provide CDoc comment blocks with the handler functions.
 *
 * SIGUSR1: This handler prints the message "Received SIGUSR1:
 * setting next signal to SIGUSR2" and sets nextSignal to SIGUSR2.
 *
 * SIGUSR2: This handler prints the message "Received SIGUSR2:
 * setting next signal to SIGUSR1" and sets nextSignal to SIGUSR1.
 *
 * SIGALRM: This handler prints "Received SIGALRM: setting next
 * signal to SIGTERM" and sets nextSignal to SIGTERM.
 *
 * SIGTERM: This handler prints "Received SIGTERM: exiting" and
 * sets running to false.
 */

#include <signal.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

/** next signal to be sent */
int nextSignal = SIGUSR1;

/** set false to exit */
bool running = true;

/**
 * Handle SIGTERM: termination signal.
 * @param sig the received signal
 */
void SIGALRM_handler(int sig) {
    // your code here
    printf("Received SIGALRM: setting next signal to SIGTERM\n");
    nextSignal = SIGTERM;
}

/**
 * Handle SIGUSR1: application specific signal.
 * @param sig the received signal
 */
void SIGUSR1_handler(int sig) {
    // your code here
    printf("Received SIGUSR1: setting next signal to SIGUSR2\n");
    nextSignal = SIGUSR2;
}

/**
 * Handle SIGUSR2: application specific signal.
 * @param sig the received signal
 */
void SIGUSR2_handler(int sig) {
    // your code here
    printf("Received SIGUSR2: setting next signal to SIGUSR1\n");
    nextSignal = SIGUSR1;

}

/**
 * Handle SIGTERM: termination signal.
 */
void SIGTERM_handler(int sig) {
    // your code here
    printf("Received SIGTERM: exiting\n");
    running = false;
}

/**
 * Register the required signal handlers.
 */
void registerSignalHandlers() {
    // your code here
    /*
     * register the handlers
     */
    signal(SIGUSR1, SIGUSR1_handler);
    signal(SIGUSR2, SIGUSR2_handler);
    signal(SIGALRM, SIGALRM_handler);
    signal(SIGTERM, SIGTERM_handler);
}

/**
 * Main method sends the next signal to the current process.
 */
int main() {
    /*
     * use command "gcc -Wall main.c -o output" to compile the program
     * then run "./output" to check the output
     */
    setlinebuf(stdout); // buffer lines
    printf("Start problem 3\n");
    
    const unsigned int ALARM_SECONDS = 15;  // alarm period
    const unsigned int SLEEP_SECONDS = 2;   // sleep period
    
    // register the required signal handlers
    registerSignalHandlers();
    
    printf("Setting alarm for %d seconds\n", ALARM_SECONDS);
    alarm(ALARM_SECONDS);  // sends SIGALRM after ALARM_SECONDS
    
    // run until alarm goes off
    while (running) {
        sleep(SLEEP_SECONDS);
        raise(nextSignal); // sends signal to current process
    }
    
    printf("End problem 3\n");
}
/*************3.c*******************/
