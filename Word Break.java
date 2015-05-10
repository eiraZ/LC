/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one
or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

Solution: 
(1)Recursion(TLE)
(2)DP: subproblem: for index [0, i], determine whether this string is breakable or not. 
*/
public boolean wordBreakDP(String s, Set<String> dict) {
    if (s.length() == 0) return true;
    boolean[] res = new boolean[s.length()+1];
    res[0] = true;
    
    for (int end = 1; end <=s.length(); end++){
        String temp = s.substring(0, end);
        if (dict.contains(temp){
            res[end] = true;
            continue;
        }
        for (int i = 0; i<end; i++){
            String sub = s.substring(i, end);
            res[end] = res[i] &&(dict.contains(sub));
            if (res[end]) break;
        }
        /*
        for (int i = 0; i<=end; i++){
            String sub = s.substring(i, end);
            res[end] = res[i] &&(dict.contains(sub));
            if (res[end]) break;
        }
        */
    }
    return res[s.length()];
}
//TLE
public boolean wordBreak_Recursion(String s, Set<String> dict) {
    if (s.length() == 0) return true;
    if (dict.isEmpty()) return false;
    if (dict.contains(s)) return true;
    
    for (int i = 1; i <= s.length(); i++){
        String temp = s.substring(0, i);
        if (dict.contains(temp)){
            if(wordBreak_Recursion(s.substring(i), dict)){
                return true;
            }
        }
    }
    return false;
}
