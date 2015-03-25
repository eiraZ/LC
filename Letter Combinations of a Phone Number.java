/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Solution: 1. DFS. digits.length() == m. every digit contains 4 chars at most. Time: O(4^m)
          2. Memorization. from back to the front. Time: O(4^m).
*/
public List<String> letterCombinations(String digits) {
    List<String> res = new ArrayList<String>();
    if (digits == null) return res;
    res.add("");
    if (digits.length() == 0) return res;
    
    String[] mem = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder sb = new StringBuilder();
    
    helper(res, sb, mem, digits, 0);
    return res;
}
private void helper(List<String> res, StringBuilder sb, String[] mem, String digits, int step){
    if (step == digits.length()){
        res.add(sb.toString());
        return;
    }
    String cur = mem[digits.charAt(step)-'0'];
    for (int i = 0; i < cur.length(); i++){
        sb.append(cur.charAt(i));
        helper(res, sb, mem, digits, step+1);
        sb.deleteCharAt(sb.length() - 1);
    }
}

public List<String> letterCombinationsMemo(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits.length() == 0)   return res;
        
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Map<Integer, List<String>> combinations = new HashMap<>();
        //from back to the front
        int len = digits.length();
        for (int i = len-1; i>=0; i--){
            char c = digits.charAt(i);
            String cmb = map[c-'0'];
            List<String> ith = new ArrayList<>();
            List<String> next = combinations.get(i+1);
            for (int j = 0; j < cmb.length(); j++){
                if(next == null){
                    String sub = "" + cmb.charAt(j);
                    ith.add(sub);
                    continue;
                }
                for(String nextStr: next){
                    String sub = "" + cmb.charAt(j) + nextStr;
                    ith.add(sub);
                }
                
            }
            combinations.put(i, ith);
        }
        return combinations.get(0);
}
