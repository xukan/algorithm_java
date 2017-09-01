package algorithm_java;

//Microsoft Facebook

import java.util.*;
/* http://www.cnblogs.com/springfor/p/3869666.html
 * 这是一道简化路径的题，路径简化的依据是：
 * 当遇到“/../"则需要返回上级目录，需检查上级目录是否为空。
 * 当遇到"/./"则表示是本级目录，无需做任何特殊操作。 
 * 当遇到"//"则表示是本级目录，无需做任何操作。
 * 当遇到其他字符则表示是文件夹名，无需简化。
 * 
 * 先将字符串依"/"分割出来，然后检查每个分割出来的字符串。
 * 当字符串为空或者为"."，不做任何操作。
 * 当字符串不为".."，则将字符串入栈。
 * 当字符串为"..", 则弹栈（返回上级目录）。这一点可以举个例子，比如cd /a/b/../, 表示进入目录a后，再进入目录b，/../表示返回上一级目录，又回到了目录a
 * */
 
//处理细节：
/*
 * 判断字符串相等与否要用.equals()，因为是引用类型。
 * 要注意split函数是可以split出空字符的，例如：//b/ 会被split结果为["","b"]。
 * 最后使用StringBuilder进行拼接，由于String在每次对字符串修改时候均会生成一个新的String，效率较低，
 * 一般会采用StringBuilder或者StringBuffer来进行字符串修改的操作
 * StringBuilder是StringBuffer的简易替换，是非线程安全的，而StringBuffer是线程安全的。
 * */

/* http://blog.csdn.net/fightforyourdream/article/details/16917563
 * 发现Java里面的LinkedList实现了栈和队列的所有方法，而且还有重复的！值得注意的是，
 * LinkedList中的pop()对应的是remove()或者removeHead()  即从链表头移除，而不是removeLast()。
 * 所以在LinkedList中，进栈(push())出栈(pop())都是在链表头部进行，进队列（add()）是从尾部进入，出队列是从头部被移除(remove())。
 * */
public class SimplifyPath  {
	public static String simplifyPath(String path) {  
		if(path.length() == 0)
            return "";
        Stack<String> stack = new Stack<String>();
        String[] tokens = path.split("/");
        for(String token : tokens){
            if(token.equals(".") || token.equals(""))
                continue;
            else if(token.equals("..")){
                if( !stack.isEmpty() )
                    stack.pop();
            }else
                stack.push(token);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.empty())
            sb.insert(0, stack.pop()).insert(0, "/");
        return sb.length() == 0? "/": sb.toString();
    }
	
	public static void main(String[] args) {
		//String path = "/a/./b/../c//d";
		//String initialPath = "/";
		//String initialPath = "/.";  这个例子说明循环中的比较要用.equals();
		//String initialPath = "/..";
//		String path = "/home/../../..";
		String path = "/abc/...";
		String res = simplifyPath(path);
		System.out.println(res);
	}
}