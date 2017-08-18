package algorithm_java;

/*  each number has its unique letter to distinguish itself from others
 *  if the letter is not unique, we can remove the letter that appears in other numbers.
 *  zero :  z o
 *  one  :  o
 *  two  :  w o
 *  three : h
 *  four :  u  o f
 *  five :  f   i  v
 *  six  :  x   i
 *  seven: v
 *  eight: g   i  h
 *  nine : i   
 *  
 * */

public class ReconstructOriginalDigitsfromEnglish {
	public String originalDigits(String s) {
        int[] count = new int[10];
        for(char c: s.toCharArray()){
            if(c=='z')   
                count[0]++;
            if(c=='o')  //0 2 4
                count[1]++;
            if(c=='w')
                count[2]++;
            if(c=='h')  // 8
                count[3]++;
            if(c=='u')
                count[4]++;
            if(c=='f')  // 4
                count[5]++;
            if(c=='x')
                count[6]++;
            if(c=='v') // 5
                count[7]++;
            if(c=='g')
                count[8]++;
            if(c=='i')  //5 6 8
                count[9]++;
        }
        count[1] = count[1] - count[0] - count[2] - count[4];
        count[3] -= count[8];
        count[5] -= count[4];
        count[7] -= count[5];
        count[9] = count[9] - count[5] - count[6] - count[8] ;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<count.length;i++){
            for(int j=0;j<count[i];j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
