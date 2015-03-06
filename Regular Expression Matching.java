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

Solution: Recursion: we must have a char before '*' so that it can do the match process. 
          DP: boolean res[][]: res[i][j]: match s [0, i) with p [0, j)
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
            //s, p.substring(2): eliminate ch2,*
            //s.substring(1), p: more matching from p.. * represents p.charAt(0)
            return isMatchRe(s, p.substring(2)) || isMatchRe(s.substring(1), p);
        }
        return isMatchRe(s.substring(1), p.substring(1));
    }
    // p.length() >1 &&(s.length() ==0 || p.charAt(0)!=s.charAt(0))
    // only if p.charAt(1) =='*', we could do the match: cut ch2, * in p and continue our match.
    return p.charAt(1) == '*' && isMatch(s, p.substring(2));
}

public boolean isMatchDP(String s, String p){
        int M = s.length(), N = p.length();
        boolean[][] res = new boolean[M+1][N+1];
        
        res[0][0] = true;
        for(int i= 2; i <= N; i++){
            res[0][i] = res[0][i-2] && p.charAt(i-1)=='*';
        }
        
        for (int i = 1; i<=M; i++){
            for (int j = 1; j<=N; j++){
                char sc = s.charAt(i-1);
                char pc = p.charAt(j-1);
                if (pc != '*'){
                    res[i][j] = res[i-1][j-1] &&(sc == pc || pc =='.');
                }else{
                    res[i][j] = res[i][j-2]; //eliminate "c*" in String p.
                    if (sc == pc.charAt(j-2) || pc.charAt(j-2)=='.'){
                        res[i][j] = res[i][j] || res[i-1][j];
                    }
                }
            }
        }
        return res[M][N];
}

