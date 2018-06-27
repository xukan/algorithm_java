package algorithm_java;

public class CompressedStringIterator {
	int count;
    char cur;
    String s;
    int index;
    public CompressedStringIterator(String compressedString) {
        s = compressedString;
        cur = ' ';
        count = 0;
        index = 0;
    }
    
    public char next() {
        if(count>0){
            count--;
            return cur;
        }else if(count == 0 && index < s.length()){
            cur = s.charAt(index++);
            int n = 0;
            while(index< s.length() && Character.isDigit(s.charAt(index)))
                n = n*10 + s.charAt(index++) - '0';
            count = n;
            count--;
            return cur;
        }
        return ' ';
    }
    
    public boolean hasNext() {
        return count > 0 || index < s.length();
    }
    
    public static void main(String[] args) {
    	CompressedStringIterator iterator = new CompressedStringIterator("x6");

		iterator.next(); // return 'L'
		iterator.next(); // return 'e'
		iterator.next(); // return 'e'
		iterator.hasNext(); // return true
//		iterator.next(); // return 't'
//		iterator.next(); // return 'C'
//		iterator.next(); // return 'o'
//		iterator.hasNext();
//		iterator.next(); // return 'd'
//		iterator.next(); // return 'e'
//		iterator.hasNext(); // return false
//		iterator.next(); // return ' '
	}
}
