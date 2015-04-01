/*
Determine whether an integer is a palindrome. Do this without extra space.

Solution: 1. reverse and compare. 
              //reverse and compare
              //what if reverse if out of range?
              //consider +, -. if negative number is not valid. simply return false
          2. count the digits, check from sides to center.
*/

public boolean isPalindrome1(int x) {

        long reverse = 0;
        boolean isNeg = x < 0;
        long longX = Math.abs((long)x);
        
        while (x != 0){
            long temp = x%10;
            reverse = reverse * 10 + temp;
            x = x/10;
        }
        if (isNeg && reverse > Math.abs((long)Integer.MIN_VALUE))   return false;
        if (!isNeg && reverse > Integer.MAX_VALUE)  return false;
        return longX == reverse;
    }
    
public boolean isPalindrome1(int x) {
        if (x < 0)  return false;
        int d = 1;
        while (x /d >= 10){
            d *= 10;
        }
        while (d > 1){
            if (x / d != x%10)  return false;
            x = (x%d)/10;
            d /= 100;
        }
        return true;
}
