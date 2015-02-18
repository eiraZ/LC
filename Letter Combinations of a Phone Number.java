/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
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