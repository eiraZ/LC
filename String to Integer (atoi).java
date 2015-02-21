/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself 
what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all 
the input requirements up front.
*/
public int atoi(String str) {
    long res = 0;
    boolean isNeg = false;
    String s = str.trim();
    if (s.length() == 0)    return 0;
    int i = 0;
    if (s.charAt(i) == '-' || s.charAt(i) == '+'){
        if(s.charAt(i) == '-'){
            isNeg = true;
        }
        i++;
    }
    
    while (i < s.length()){
        if (s.charAt(i) < '0'|| s.charAt(i) > '9'){
            break;
        }
        res = res * 10 + (s.charAt(i) - '0');
        if (isNeg && res > Math.abs((long)Integer.MIN_VALUE))   return Integer.MIN_VALUE;
        if (!isNeg && res > Integer.MAX_VALUE)  return Integer.MAX_VALUE;
        i++;
    }
    if(isNeg){
        return (int)(-res);
    }
    return (int)res;
}
