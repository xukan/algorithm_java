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
	/*what is the difference between call once and call multiple times?
	 * The start pointer of array will change if you call read() function, because you want to read the file in a stream style instead of always starting over.
	 * The only thing is when you call read4() which reads 4 bytes into your buffer you might read more than you need, so you want to store those bytes in the structure,
	 * and next time you call read will start from those stored bytes, then read more from the file.
	 * Think that you have 4 chars "a, b, c, d" in the file, and you want to call your function twice like this:
	 * read(buf, 1); // should return 'a'
	 * read(buf, 3); // should return 'b, c, d'
	 * All the 4 chars will be consumed in the first call. So the tricky part of this question is how can you preserve the remaining 'b, c, d' to the second call.
	 * */
	/*因为要调用多次，这里又多了一些corner case：
	 * 第一次调用时，如果read4读出的多余字符我们要先将其暂存起来，这样第二次调用时先读取这些暂存的字符
	 * 第二次调用时，如果连暂存字符都没读完，那么这些暂存字符还得留给第三次调用时使用
	 * 所以，难点就在于怎么处理这个暂存字符。
	 * 使用buffCnt记录每次读出的字符数,buffPtr来记录buf4中读出的字符的位置
	 * 如果buf4的字符数>n, 那么下一次再调用read的时候需要先把上次剩余的字符读出来,
	 * 只有在read4的字符都读出来时会将buffPtr==0,只有在buffPtr==0时才会继续调用read4继续读,否则继续读buf4剩余的字符直到都读出来才会
	 * 将buffPtr置为0
	 * */
	//some more classification
	//https://discuss.leetcode.com/topic/84442/the-missing-clarification-you-wish-the-question-provided
	int buffCnt = 0;
    int buffPtr = 0;
    char[] buf4 = new char[4];
    public int readII(char[] buf, int n) {
        int ptr = 0;
        while(ptr<n){
            if(buffPtr == 0)
                buffCnt = read4(buf4);
            if(buffCnt == 0)
                break;
            while(ptr<n && buffPtr < buffCnt)
                buf[ptr++] = buf4[buffPtr++];
            if(buffPtr == buffCnt)
                buffPtr = 0;
        }
        return ptr;
    }

    //
    int ptr = 0;
//    int write_pos = 0;
    int buffcnt = 0;
    String cur = "";
    //char[] buf4 = new char[4];
    public String read(char[] buf) {
    	int i=0;
    	String res = "";
    	while(i == 0 || res.charAt(i-1)!='\n'){
    		 if(ptr>=buffcnt){
    			 ptr= 0;
    			 cur = read4();
    			 buffcnt = cur.length();
    			 if(buffcnt == 0)
    				 return res;
    		 }
    		 res += cur.charAt(ptr++);
    		 i++;
    	 }
    	return res;
    }
}
