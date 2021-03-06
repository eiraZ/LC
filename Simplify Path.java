/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".

Solution: stack. ".." pop, else if not "." push
*/
public String simplifyPath(String path) {
    if(path.length() == 0) return "";
    Stack<String> stack = new Stack<String>();
    
    int i = 0;
    int len = path.length();
    while ( i < len){
        StringBuilder sb = new StringBuilder();
        while ( i< len && path.charAt(i) !='/'){
            sb.append(path.charAt(i));
            i++;
        }
        String temp = sb.toString();
        if(temp.length()>0){
            if (temp.equals("..")){
                if(!stack.empty()){
                    stack.pop();
                }
            }else if (!temp.equals(".")){
                stack.push(temp);
            }
        }
        i++;
    }
    
    StringBuilder sb = new StringBuilder();
    while(!stack.empty()){
        sb.insert(0, stack.pop());
        sb.insert(0, "/");
    }
    if (sb.length() == 0){
        sb.append("/");
    }
    return sb.toString();
}

 public String simplifyPath2(String path) {
        if(path.length() == 0)  return path;
        Stack<String> stack = new Stack<>();
        
        int i = 0;
        int len = path.length();
        while (i < len){
            while(i < len && path.charAt(i) == '/'){
                i++;
            }
            StringBuilder sb = new StringBuilder();
            while (i < len && path.charAt(i) != '/'){
                sb.append(path.charAt(i));
                i++;
            }
            i++;
            String s = sb.toString();
            if(s.length() == 0) continue;
            if(s.equals("."))   continue;
            else if(s.equals("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
                //else ...
            }else{
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        if(stack.isEmpty()) return "/";
        while(!stack.isEmpty()){
            String str = stack.pop();
            sb.insert(0, str);
            sb.insert(0, '/');
        }
        return sb.toString();
        
    }
