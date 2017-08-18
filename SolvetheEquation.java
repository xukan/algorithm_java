package algorithm_java;

//Amazon

//similar question
//Fraction Addition and Subtraction

public class SolvetheEquation {
	public String solveEquation(String equation) {
        String[] parts = equation.split("=");
        int[] leftPart = evaluate(parts[0]);
        int[] rightPart = evaluate(parts[1]);
        if(leftPart[0] == rightPart[0] && leftPart[1] == rightPart[1]) {
            return "Infinite solutions";
        }else if (leftPart[0] == rightPart[0]){
            return "No solution";
        }
        return "x="+ (rightPart[1]-leftPart[1])/(leftPart[0]-rightPart[0]);
    }
    
    private int[] evaluate(String str){
    	//explanation on look-ahead and look-behind
    	//https://stackoverflow.com/questions/19951850/split-string-with-regex-but-keep-delimeters-in-match-array
        String[] tokens = str.split("(?=[+-])");  // ()for match/capturing group; ?= for (positive lookahead)match and include in res; [+-] means + or -;
        int[] res = new int[2]; // coefficient for x;  coefficient for constant
        for(String token : tokens) {
            if (token.equals("+x") || token.equals("x"))
            	res[0]++; // x means 1x
            else if (token.equals("-x"))
            	res[0]--;// -x means -1x
            else if (token.contains("x")) {
                res[0] += Integer.parseInt(token.substring(0, token.length()-1)); 
            }else {
                res[1] += Integer.parseInt(token);
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
    	SolvetheEquation s = new SolvetheEquation();
		String equation = "2x+3x-6=x+2";
//		String equation ="2x=x";
//		String equation ="x=x";
//		String equation ="x=x+2";
		String res = s.solveEquation(equation);
		System.out.println(res);
	}
}
