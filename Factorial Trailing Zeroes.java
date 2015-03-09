/*
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

*/
    public int trailingZeroes(int n) {
        if (n <=0)  return 0;
        int res = 0;
        while( n > 0){
            res += n/5;
            n/=5;
        }
        return res;
        
    }
