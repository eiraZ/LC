/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Solution: (1) Stack. extra space.
          (2) two pointers. from back to the front.
          
*/

public String reverseWordsTwoPointers(String s) {
        if(s.length() == 0) return "";
        int i = s.length() - 1;
        StringBuilder resb = new StringBuilder();
        while (i >=0){
            while (i >=0 && s.charAt(i) == ' '){
                i--;
            }
            StringBuilder sb = new StringBuilder();
            while (i >= 0 && s.charAt(i) != ' '){
                sb.insert(0, s.charAt(i));
                i--;
            }
            if(sb.length() > 0){
                resb.append(sb.toString());
                resb.append(" "); 
            }
        }
        if(resb.length() >0){
            resb.deleteCharAt(resb.length() - 1);
        }
        
        return resb.toString();
    }
    
public String reverseWordsStack(String s) {    
     
        Stack<String> stack = new Stack<String>();
        int i = 0;
        int len = s.length();
        
        int left = 0;
        while (i < len){
            while (i < len && s.charAt(i) !=' '){
                i++;
            }
            String cur = s.substring(left, i);
            if(cur.length() > 0){
                stack.push(cur);
            }
            i++;
            left = i;
        }
        if(stack.isEmpty()){
            stack.push(s.substring(left, i));
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        
        return sb.toString();
        
  }
