package algorithm_java;

// Facebook ,  LinkedIn

//The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.

public class FindtheCelebrity {
	//two-pass, tc: O(n)
	public int findCelebrity(int n) {
        int candidate = 0;
        for(int i=1;i<n;i++)
            if(knows(candidate, i))
                candidate = i;
        for(int i=0;i<n;i++){
            if(i!=candidate && (!knows(i, candidate) || knows(candidate, i) ))
                return -1;
        }
        return candidate;
    }
}
