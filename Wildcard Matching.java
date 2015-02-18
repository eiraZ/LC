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

Solution: DP. boolean[pattern.length() +1][s.length() + 1] subproblem: pattern[0, i] matches s or not [0, j]
*/
public boolean isMatch(String s, String p){
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
            int j = =;
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
    
