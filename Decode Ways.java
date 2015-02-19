/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.

Solution: DP
*/
    public int numDecodings(String s) {
        if(s.length()==0||s==null||s.charAt(0)=='0'){
            return 0;
        }
        int[] res = new int[2];
        res[0] = 1;
        res[1] = 1;
        
        // for (int i = 1; i<s.length(); i++){
        //     int temp = 0;
        //     int n = s.charAt(i) - '0';
        //     if(n>0){
        //         temp = res[1];
        //     }
        //     int n2 = (s.charAt(i-1) - '0')*10 + n;
        //     if(n2>=10 && n2<=26){
        //         temp += res[0];
        //     }
        //     res[0] = res[1];
        //     res[1] = temp;
        // }
        // return res[1];

        for (int i = 1; i< s.length(); i++){
            String temp1 = new String(s.charAt(i)+"");
            int cur = 0;
            if (isValid(temp1)){
                cur += res[1];
            }
            String temp2 = s.substring(i-1, i+1);
            if (isValid(temp2)){
                cur += res[0];
            }
            res[0] = res[1];
            res[1] = cur;
        }
        return res[1];
    }
    
    private boolean isValid(String s){
        if (s.charAt(0) == '0') return false;
        int num = Integer.parseInt(s);
        return num >= 1 && num <= 26;
    }
    
    
