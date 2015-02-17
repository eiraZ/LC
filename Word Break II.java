/*
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary
word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].

Solution: first, check if current string is breakable(DP). subproblem: from (0, i), this string is breakable.
          then DFS for every solution.
*/
public List<String> wordBreak(String s, Set<String> dict) {
        List<String> res = new ArrayList<String>();
        if(s==null||s.length()==0){
            return res;
        }
        if(isBreakable(s,dict)){
            helper(res, s, dict, "", 0);
        }
        return res;
        
    }
    private void helper(List<String> res, String s, Set<String> dict, String sub, int start){
        if (start == s.length()){
            res.add(sub);
            return;
        }
        for (int end = start+1; end <= s.length(); end++){
            String temp = s.substring(start, end);
            if (dict.contains(temp)){
                if (sub.length() == 0){
                    helper(res, s, dict, temp, end);
                }else{
                    helper(res, s, dict, sub + " " + temp, end);
                }
            }

        }
    }
    
    private boolean isBreakable(String s, Set<String> dict){
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        
        for (int end = 1; end <= s.length(); end++){
            String temp = s.substring(0, end);
            if (dict.contains(temp)){
                res[end] = true;
                continue;
            }
            for (int i = 0; i< end; i++){
                String sub = s.substring(i, end);
                res[end] = res[i] && dict.contains(sub);
                if (res[end]) break;
            }
        }
        return res[s.length()];
    }
