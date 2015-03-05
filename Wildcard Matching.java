/*
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false

Solution: (1) Recursion.
               if p.charAt(0) != '*', 3 possibilities:
                  1. p.charAt(0) == s.charAt(0) isMatch(s.substring(1), p.substring(1));
                  2. p.charAt(0) == '?' isMatch(s.substring(1), p.substring(1))
                  3. p.charAt(0) != '?' && p.charAt(0) != s.charAt(0) false;
               if p.charAt(0) =='*', then we can consider: 
                1. '*' represents an empty string: 
                    isMatch(s, p.substring(1))
                2. '*' represents current s.charAt(0) and keep this '*'(maybe we'll use it later)
                    isMatch(s.substring(1), p)
        (2)DP. boolean[pattern.length() +1][s.length() + 1] subproblem: pattern[0, i] matches s or not [0, j]
        (3)2 pointers. maintain 2 pointers for backup: sback: last match index in s, pback: last match index in p.
*/
public boolean isMatchRecursion(String s, String p){
    public boolean isMatch(String s, String p) {
        if (s == null && p == null)  return false;
        int M = s.length(), N = p.length();
        if (M == 0) return N==0;
        if (N == 0) return false;
        
        if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?'){
            return isMatchRecursion(s.substring(1), p.substring(1));
        }
        return p.charAt(0) == '*' && (isMatchRecursion(s, p.substring(1)) || isMatchRecursion(s.substring(1), p));
    }
public boolean isMatchDP(String s, String p){
    if( p.length() == 0) return s.length() == 0;
    if (s.length() == 0) return false;
    
    boolean[][] res = new boolean[pattern.length() + 1][s.length() + 1];
    res[0][0] = true;
    
    for (int i = 1; i <= p.length(); i++){
        char c = p.charAt(i -1);
        if (c != '*'){
            for (int j = 1; j < s.length(); j++){
                res[i][j] = res[i-1][j-1] && (s.charAt(j-1) == c || c == '?');
            }
        }else{
            res[i][0] = res[i-1][0];
            int j = 0;
            while (j <= s.length() && !res[i-1][j]){
                j++;
            }
            while (j <=s.length()){
                res[i][j] = true;
                j++;
            }
        }
    }
    return res[p.length()][s.length()];
}

public boolean isMatch_DP2(String s, String p){
    if( p.length() == 0) return s.length() == 0;
    if (s.length() == 0) return false;
    
    boolean[] res = new boolean[s.length() + 1];
    res[0] = true;
    
    for (int i = 0; i< p.length(); i++){
        char c = p.charAt(i);
        if ( c != '*'){
            for (int j = s.length() - 1; j>= 0; j--){
                res[j+1] = res[j] && (s.charAt(j) == c || c =='?');
            }
        }else{
            //c == '*'
            int j = 0;
            for (; j <= s.length() && !res[j] ; j++);
            while (j <= s.length()){
                res[j] = true;
                j++;
            }
        }
        res[0] = res[0] && (c=='*');
        
    }
    return res[s.length()];
}

public boolean isMatch(String s, String p) {
        /* 2 pointers*/
        if (s.length() == 0 && p.length() == 0) return true;
        int sback = -1, pback = -1, i = 0, j = 0;
        int M = s.length(), N = p.length();
        while (i < M){
            if (j < N && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')){
                i++;
                j++;
            }else if( j < N && p.charAt(j) =='*'){
               //ignore duplicate '*' until p.charAt(j) != '*'
                while (j < N && p.charAt(j) == '*'){
                    j++;
                }
                if (j == N)     return true;
                sback = i;
                pback = j;
            }else{
                //mismatch happens, 
                //if we have backup, apply '*' for replacement. that is s.charAt(i) can be represented by '*'
                if (sback == -1)    return false;
                i = ++sback;
                j = pback;
            }
        }
        while (j < N && p.charAt(j) =='*') j++;
        return j==N;
}
    
