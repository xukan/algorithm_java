package algorithm_java;

public class IsSubsequence {
	//solutionI, based on Edit distance
	public boolean isSubsequence_ed(String s, String t) {
        int len1 = s.length(), len2=t.length();
        int pos=0;
        for(int i=0;i<len1;i++){
            boolean isMatch = false;
            for(int j=pos;j<len2;j++){
                if(s.charAt(i) == t.charAt(j)){
                    pos=j+1;
                    isMatch= true;
                    break;
                }
            }
            if(!isMatch)return false;
        }
        return true;
    }
	
	//solution2, search
	public boolean isSubsequence_search(String s, String t) {
        if(s.length()==0)
            return true;
        int len1 = s.length(), len2=t.length();
        int indexS=0, indexT=0;
        while(indexT<len2){
            if(s.charAt(indexS) == t.charAt(indexT)){
                indexS++;
            }
            if(indexS == len1)
                return true;
            indexT++;
        }
        return false;
    }
	
	//solution3, more concise, indexOf
	//Returns the index within this string of the first occurrence of the specified character, starting the search at the specified index.
	public boolean isSubsequence(String s, String t) {
	    int lastIndex = -1;
	    for (char c : s.toCharArray())
	        if ((lastIndex = t.indexOf(c, lastIndex + 1)) < 0) 
	            return false;
	    return true;
	}
}
