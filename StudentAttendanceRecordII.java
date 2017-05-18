package algorithm_java;

import java.util.ArrayList;
import java.util.List;

public class StudentAttendanceRecordII {
	/*
	int res;
    public int checkRecord(int n) {
        final int mod = 1000000007;
        String[] records = {"A", "L",  "P"};
        List<String> sol = new ArrayList();
        List<List<String>> rewards = new ArrayList<List<String>>();
        res =0;
        helper(records, n, sol, rewards);
        for(List<String> l: rewards){
        	for(String str: l){
        		System.out.print(str+" ");
        	}
        	System.out.println();
        }
        return rewards.size();
    }
    
    public void helper(String[] records, int n, List<String> sol, List<List<String>> rewards){
        if(sol.size() == n){
            rewards.add(new ArrayList<String>(sol));
            res++;
            return;
        }
        for(int i=0;i<records.length;i++){
            if(i==0&& sol.contains("A"))
                continue;
            else if(records[i].equals("L") && sol.size()>1 &&sol.get(sol.size()-1).equals("L") &&sol.get(sol.size()-2).equals("L") )
                continue;
            sol.add(records[i]);
            helper(records, n, sol, rewards);
            sol.remove(sol.size()-1);
        }
    }
    */
    
	int res;
    public int checkRecord(int n) {
        final int mod = 1000000007;
        String[] records = {"A", "L",  "P"};
        StringBuilder sb = new StringBuilder();
        List<String> rewards = new ArrayList<String>();
        res =0;
        helper(records, n, sb, rewards);
        for(String str: rewards){
        	System.out.print(str+" ");
        }
        return rewards.size()%mod;
    }
    
    public void helper(String[] records, int n, StringBuilder sb, List<String> rewards){
        if(sb.length() == n){
            rewards.add(sb.toString());
            res++;
            return;
        }
        for(int i=0;i<records.length;i++){
        	String tmp = sb.toString();
            if(i==0&&tmp.contains("A") )
                continue;
            else if(records[i].equals("L") && sb.length()>1 &&sb.substring(sb.length()-2).equals("LL") )
                continue;
            sb.append(records[i]);
            helper(records, n, sb, rewards);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    public static void main(String[] args) {
    	StudentAttendanceRecordII s = new StudentAttendanceRecordII();
    	int res = s.checkRecord(2);
    	System.out.println(res);
	}
}
