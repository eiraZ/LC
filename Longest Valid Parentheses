/*
Longest Valid Parentheses
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses
substring.
For "(()", the longest valid parentheses substring is "()", which has length = 2.
Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
Tags Dynamic Programming String

Solution: (1) Use a stack<Integer> for storing opening brackets, and integer is the number of valid pairs before the opening 
              brackets. 
              once we meet a closing one, check stack.isEmpty()? 
                    yes: closing one can't have valid pairs, count = 0;
                    no: have a pair, + consecutive pairs with this opening bracket. update count+= 1+ stack.pop()
              return count*2 (pairs)
              O(n)
          (2) DP: subproblem: longest valid parentheses starting from current bracket. res[i]
                  if it is ')', res[i] = 0;
                  else:  check next available bracket( index = i + res[i+1]) + 1 is ')' or not. 
                          yes: res[i] = res[i+1] + 1, then check res[index+1] 
                          (res[index] acts like a bridge to connect parentheses)
                          be careful the bound!
              Time: O(n) Space: O(n)

*/
public int longestValidParentheses_stack(String s) {
    if (s.length()<2) return 0;
    Stack<Integer> stack = new Stack<Integer>();
    
    int count = 0;
    int res = 0;
    for (int i = 0; i< s.length(); i++){
        if (s.charAt(i) == '(' ){
            stack.push(count);
            count = 0;
        }else if ( !stack.empty()){
            count += stack.pop() + 1;
            res = Math.max(res, count);
        }else{
            count = 0;
        }
    }
    
    return res * 2;
}

public int longestValidParentheses_DP(String s) {
    if (s.length() < 2) return 0;
    
    int[] res = new int[s.length()];
    res[s.length()-1] = 0;
    
    for (int i = s.length() - 2; i>=0; i--){
        if (s.charAt(i) == ')'){
            res[i] = 0;
        }else{
            int j = i + res[i + 1] + 1;
            if (j < s.length() && s.charAt(j) ==')'){
                res[i] = res[i+1] + 2;
                if (j + 1 < s.length() && res[j+1] != 0){
                    res[i] += res[j+1];
                }
            }
        }
    }
    return res[0];
}
