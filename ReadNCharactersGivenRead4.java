package algorithm_java;

//Facebook

/*
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 * Note:
 * The read function will only be called once for each test case.
 * */

public class ReadNCharactersGivenRead4 {
	//buffer means read from a file into buffer
	//I agree this is confusing. But after trial and error, and looking at the expected outputs for given inputs -- the problem is following
    //Your objective is to return the number of characters actually read
    //if you return that, the expected output is displaying what those characters are and checks if it is matching your output
	public int read(char[] buf, int n) {
		int count = 0;
        char[] buf4 = new char[4];
        while(count < n){
            int num=read4(buf4);
            if(num ==0)
                break;
            int index =0;
            while(index<num && count <n){
                buf[count++] = buf4[index++];
            }
        }
        return count;
	}
	
	//II Note:
	//The read function may be called multiple times.
	//Bloomberg Google Facebook
	public int readII(char[] buf, int n) {
        
    }

}
