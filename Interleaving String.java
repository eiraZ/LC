
/*Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.

Solution: DP
          subproblem: boolean[][] res. res[i][j]: s1[0, i-1] + s2[0, j-1] --> s3[0, i+j-1] 
*/


public boolean isInterleave(String s1, String s2, String s3) {
        
        if(s1==null||s2==null||s3==null){
            return false;
        }
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        boolean[][] res = new boolean[s1.length()+1][s2.length()+1];
        int r = s1.length();
        int c = s2.length();
        res[0][0] = true;
        
        for (int i = 1; i <= s1.length(); i++){
            res[i][0] = (s1.charAt(i-1)== s3.charAt(i-1)) && res[i-1][0];
        }
        for (int j = 1; j<=s2.length(); j++){
            res[0][j] = (s2.charAt(j-1) == s3.charAt(j-1)) && res[0][j-1];
        }
        
        for (int i = 1; i <=s1.length(); i++){
            for (int j = 1; j<=s2.length(); j++){
                res[i][j] = (res[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1))||(res[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }
        
        return res[r][c];
