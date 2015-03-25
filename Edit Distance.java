/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is 
counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character

Solution: 
        Recursion. Duplicate work!
        DP. word1: m. word2: n
        subproblem: int[][] distance. distance[i][j] # of changes to from word1:[0, i] to  word2: [0,j]
        DP1->Time: O(mn). Space: O(mn)  DP2-> Time: O(mn). Space(On)
*/

public int minDistanceRe(String word1, String word2) {
        if (word1.length() == 0)    return word2.length();
        if (word2.length() == 0)    return word1.length();
        if(word1.equals(word2)) return 0;
        
        if(word1.charAt(0) == word2.charAt(0)){
            return minDistanceRe(word1.substring(1), word2.substring(1));
        }
        return Math.min(minDistanceRe(word1.substring(1), word2), 
                Math.min(minDistanceRe(word1.substring(1), word2.substring(1)), minDistanceRe(word1, word2.substring(1)))) + 1;
}



public int minDistanceDP1(String word1, String word2) {
    if (word1.length() == 0 && word2.length() == 0) return 0;
    if (word1.length() == 0) return word2.length();
    if (word2.length() == 0) return word1.length();
    
    int[][] distance = new[word1.length()+1][word2.length()+1];
    distance[0][0] = 0;
    
    for (int i = 1; i <= word1.length(); i++){
        distance[i][0] = i;
    }
    for (int j = 1; j <= word2.length(); j++){
        distance[0][j] = j;
    }
    for (int i = 1; i<=word1.length(); i++){
        for (int j = 1; j<= word2.length(); j++){
            if (word1.charAt(i-1) == word2.charAt(j-1)){
                distance[i][j] = distance[i-1][j-1];
            }else{
                // insert: distance[i][j-1]; delete at word1: distance[i-1][j]; replace: distance[i-1][j-1]
                distance[i][j] = Math.min(distance[i][j-1], Math.min(distance[i-1][j], distance[i-1][j-1])) + 1;
            }
        }
    }
    return distance[word1.length()][word2.length()];
}


public int minDistanceDP2(String word1, String word2) {
        int[] res = new int[word2.length() + 1];
        
        for (int j = 0; j< res.length; j++){
            res[j] = j;
        }
        
        for (int i = 1; i <= word1.length(); i++){
            int upperleftBack = res[0];
            res[0] = i;
            for (int j = 1; j <=word2.length() ; j++){
                int upperleft = upperleftBack;
                upperleftBack = res[j];
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    res[j] = upperleft;
                }else{
                    res[j] = 1 + Math.min(res[j], Math.min(res[j-1], upperleft));
                }
                
            }
        }
        return res[word2.length()];
}
