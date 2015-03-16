/*
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.

Solution: 1. Recursion
          2. DP
          //cut point: left part|right part.
          //s1.leftpart is scramble of s2.leftpart && s1.rightpart is scramble of s2.rightpart; 
            OR: s1.leftpart is scramble of s2.rightpart && s1.rightpart is scramble of s2.leftpart
*/
public boolean isScrambleRecursion(String s1, String s2) {
    //if (s1.length() == 0) return s2.length() == 0;
    //if (s1.length() != s2.length()) return false;
    return scrambleHelper(s1, s2);
}
private boolean scrambleHelper(String s1, String s2){
    if (!hasSameLetters(s1, s2))    return false;
    if (s1.length() <=1 )   return true;
    
    int len = s1.length();
    
    for (int i = 1; i<=len; i++){
        if ((scrambleHelper(s1.substring(0, i), s2.substring(0, i)) && scrambleHelper(s1.substring(i+1), s2.substring(i+1)))
        || (scrambleHelper(s1.substring(0, i), s2.substring(len-i,len)) && scrambleHelper(s1.substring(i+1), s2.substring(0, len-i)))
        ){
            return true;
        }
    }
    return false;
}
private boolean hasSameLetters(String s1, String s2){
    if (s1.length() != s2.length()) return false;
    if (s1.equals(s2)) return true;
    
    int[] count = new int[256];
    for (int i = 0; i <s1.length(); i++){
        count[s1.charAt(i)]++;
    }
    for (int i = 0; i< s2.length(); i++){
        count[s2.charAt(i)]--;
        if (count[s2.charAt(i)] < 0) return false;
    }
    return true;
}

public boolean isScrambleDP(String s1, String s2) {
    if (s1.length() == 0)   return s2.length()==0;
    if (s1.length() != s2.length())     return false;
    if (s1.equals(s2))  return true;
    
    int total = s1.length();
    boolean[][][] res = new boolean[total + 1][total][total];
    
    for (int len = 1; len <= total; len++){
        for(int start1 = 0; start1 <= total - len; start1++){
            for (int start2 = 0; start2 <= total - len; start2++){
                //res[len][start1][start2] = false;
                if (len == 1){
                    res[len][start1][start2] = (s1.charAt(start1) == s2.charAt(start2));
                }else{
                    for (int cut = 1; cut < len; cut++){
                        if((res[cut][start1][start2] && res[len-cut][start1+cut][start2+cut])
                            || (res[cut][start1][start2+len-cut] && res[len-cut][start1+cut][start2])){
                            res[len][start1][start2] = true;
                        }
                        
                    }
                }
            }
        }
    }
    return res[total][0][0];
}

public boolean isScrambleDP_if(String s1, String s2) {
        
    if (s1.length() == 0)   return s2.length()==0;
    if (s1.length() != s2.length())     return false;
    if (s1.equals(s2))  return true;
    
    int total = s1.length();
    boolean[][][] res = new boolean[total + 1][total][total];
    
    for (int len = 1; len <= total; len++){
        for(int start1 = 0; start1 <= total - len; start1++){
            for (int start2 = 0; start2 <= total - len; start2++){
                if (s1.substring(start1, start1+len).equals(s2.substring(start2, start2+len))){
                    res[len][start1][start2] = true;
                }else{
                    for (int cut = 1; cut < len; cut++){
                        if((res[cut][start1][start2] && res[len-cut][start1+cut][start2+cut])
                            || (res[cut][start1][start2+len-cut] && res[len-cut][start1+cut][start2])){
                            res[len][start1][start2] = true;
                            break;
                        }
                        
                    }
                }
            }
        }
    }
    return res[total][0][0];
}
