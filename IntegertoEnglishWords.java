package algorithm_java;

//Microsoft Facebook

public class IntegertoEnglishWords {
	//recursive
	private String[] lessThanTen = {"", "One", "Two","Three","Four","Five","Six","Seven", "Eight", "Nine"};
    private String[] lessThanTwenty = {"Ten", "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    private String[] tens = {"","","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] thousands = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";
        String res = "";
        int i= 0;
        while(num > 0){
            if (num % 1000 != 0) { //i.e input = 1000000;
                res = helper(num % 1000) + thousands[i] + " " + res;
            }
            num /= 1000;
            i++;
        }
        return res.trim();
    }
    
    public String helper(int num){
        if(num == 0) //int input = 50868;
            return "";
        else if(num < 10)
            return lessThanTen[num] + " ";
        else if(num < 20)
            return lessThanTwenty[num%10] + " ";
        else if(num < 100)
            return tens[num/10] +" " + helper(num%10);
        else
            return lessThanTen[num/100] + " Hundred " + helper(num %100);
    }
		
	
	public static void main(String[] args) {
		IntegertoEnglishWords s = new IntegertoEnglishWords();
//		int input = 1000010;
//		int input = 1234560;
		int input = 1000000;
//		int input = 50868;
		String res = s.numberToWords(input);
		System.out.println(res);
	}
}
