/*
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.

Solution: 1. Recursion: 
                    first char in S is the same with 1st char in T, 
                        2 choices: include this char, check next char in S and T; 
                                    not include this char, that is: check next char in S, but keep all chars in T
                    not the same: check next char in S, keep all chars in T
          2. DP(1 dimension; 2 dimension)
                subproblem: int[][] res. res[i][j]: # of ways to represent T[0, i] in S[0, j]. j>=i. 
                corner case: T is ""
*/
public int numDistinctRe(String S, String T) {
    if (T.length() == 0) return 1;
    if (S.length() == 0) return 0;
    if (S.length() < T.length()) return 0;
    
    if (T.charAt(0) == S.charAt(0)){
        return numDistinctRe(S.substring(1), T.substring(1)) + numDistinctRe(S.substring(1), T);
    }else{
        return numDistinctRe(S.substring(1), T);
    }
}

public int numDistinctDP1(String S, String T) {
    int[][] res = new int[T.length()+1][S.length()+1];
    
    for (int i = 0; i < S.length(); i++){
        res[0][i] = 1;
    }
    
    for (int i = 1; i <= T.length(); i++){
        res[i][0] = 0;
    }
    
    for (int i= 1; i<= T.length(); i++){
        for (int j = i; j<= S.length(); j++){
            if (T.charAt(i-1) == S.charAt(j - 1)){
                res[i][j] = res[i-1][j-1] + res[i][j-1];
            }else{
                res[i][j] = res[i][j-1];
            }
        }
    }
    
    return res[T.length()][S.length()];
    
}

    public int numDistinctDP1(String S, String T) {
        int[] res = new int[T.length()+1];
        
        res[0] = 1;
        
        for(int i=1; i <= S.length(); i++){
            for(int j = T.length(); j>= 1; j--){
                res[j] = res[j] + (S.charAt(i-1) == T.charAt(j-1)? res[j-1]: 0);
            }
        }
    }
