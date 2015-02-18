/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true

Solution: Recursion
          DP
*/
public boolean isMatchRe(String s, String p) {
    if (p.length() == 0) return s.length() == 0;
    if (s.length() == 0) return false;
    if (p.length() == 1){
        //if (p.length() != s.length()) return false;
        if (s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) return true;
        return false;
    }
    char c = p.charAt(0);
    if (s.length() > 0 && (s.charAt(0) == c || c == '.')){
        if (p.charAt(1) == '*'){
            
            return isMatchRe(s, p.substring(2)) || isMatchRe(s.substring(1), p);
        }
        return isMatchRe(s.substring(1), p.substring(1));
    }
    return p.charAt(1) == '*' && isMatch(s, p.substring(2));
}
/*
public boolean isMatchDP(String s, String p){
    if (p.length() == 0) return s.length() == 0;
    if (s.length() == 0) return false;
    
    boolean[][] res = new boolean[p.length() + 1][s.length() + 1];
    res[0][0] = true;
    
    for (int i = 0; i< p.length(); i++){
        char c = p.charAt(i);
        if (c != '*'){
            for (int j = 0; j< s.length(); j++){
                res[i+1][j+1] = res[i][j] && (s.charAt(j) == c || c =='.');
            }
        }else{
            // '*'
            
        }
    }
    
    
}
*/
