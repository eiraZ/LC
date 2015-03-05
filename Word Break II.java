/*
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary
word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].

Solution: first, check if current string is breakable(DP). subproblem: from (0, i), this string is breakable.
          then (1)DFS for every solution.
               (2)Memo string in a map: Map<Integer, ArrayList<String>> path. 
                  key: end index. value: list of string that can be breakable between (0, key)
*/
public List<String> wordBreakDFS(String s, Set<String> dict) {
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
    
    public List<String> wordBreakMemo(String s, Set<String> dict) {
        List<String> res = new ArrayList<String>();
        if(s==null||s.length()==0){
            return res;
        }
        if (!isBreakable(s, dict))  return res;
        Map<Integer, List<String>> path = new HashMap<Integer, List<String>>();
        memoHelper(path, s, dict);
        
        return path.get(s.length());
        
        
    }
    private void memoHelper(Map<Integer, List<String>> path, String s, Set<String> dict){
        for (int i = 0; i<= s.length(); i++){
            path.put(i, new ArrayList<String>());
        }
        path.get(0).add("");
        int n = s.length();
        for (int len = 1; len <= n; len++){
            String temp = s.substring(0, len);
            if (dict.contains(temp)){
                path.get(len).add(temp);
            }
            for (int cut = 1; cut < len; cut++){
                String sub = s.substring(cut, len);
                if (dict.contains(sub)){
                    //pad with path.get(cut) as previous words
                    for (String pre: path.get(cut)){
                        String current = pre + " " + sub;
                        path.get(len).add(current);
                    }
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
