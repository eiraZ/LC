/*
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

*/

public int singleNumber(int[] A) {
        int res = 0;
        for (int i = 0; i < 32; i++){
            int bit = 0;
            for (int j = 0; j < A.length; j++){
                bit += ((A[j] >>i) & 1);
            }
            int digit = bit%3;
            res |= (digit<<i);
        }
        return res;
}

public int singleNumber(int[] A) {
        int one = 0, two = 0, three = 0;
        for (int i = 0; i < A.length; i++){
            two |= (one & A[i]);
            one ^= A[i];
            three = ~(one & two);
            one &= three;
            two &= three;
        }
        return one;
        
}

