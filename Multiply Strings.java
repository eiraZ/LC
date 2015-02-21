/*
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.

Solution: reverse number: from lower to higher. 
*/
public String multiply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        
        int[] d = new int[num1.length() + num2.length()];
        
        for(int i=0; i<num1.length();i++){
            int t = num1.charAt(i)-'0';
            for(int j=0; j<num2.length();j++){
                d[i+j] += t * (num2.charAt(j)-'0');
            }
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i=0; i<d.length; i++){
            d[i] += carry;
            carry = d[i]/10;
            d[i] = d[i]%10;
            sb.insert(0, d[i]);
        }
        while (sb.length() > 0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        
        return sb.length()==0? "0": sb.toString();
}
