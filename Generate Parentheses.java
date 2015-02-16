/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"

*/
public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<String>();
    if (n <= 0) return res;
    StringBuilder sb = new StringBuilder();
    helper(res, sb, n, n);
    return res;
}

private void helper(List<String> res, StringBuilder sb, int left, int right){
    if (left < 0 || right < 0) return;
    
    if (left == 0 && right == 0){
        res.add(sb.toString());
        return;
    }
    if (left > 0 ){
        sb.append("(");
        helper(res, sb, left-1, right);
        sb.delete(sb.length() - 1);
    }
    if (right > left){
        sb.append(")");
        helper(res, sb, left, right-1);
        sb.delete(sb.length() - 1);
    }
}
