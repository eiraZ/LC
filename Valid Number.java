/*
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. 
You should gather all requirements up front before implementing one.
*/
public boolean isNumber(String s) {
    if (s == null)  return false;
    String str = s.trim();
    if(str.length() == 0)   return false;
    int len = str.length();
    
    boolean num = false;
    boolean exp = false;
    boolean dot = false;
    
    for (int i = 0; i< len; i++){
        char c = str.charAt(i);
        if (c=='e' || c == 'E'){
            if (!num || exp)    return false;
            exp = true;
            num = false;
        }else if(c=='.'){
            if(exp || dot)  return false;
            dot = true;
        }else if(c>='0' && c <='9'){
            num = true;
        }else if(c =='+' || c == '-'){
            if(i!=0 && (str.charAt(i-1)!= 'e' ||str.charAt(i-1)!='E')){
                return false;
            }
        }else{
            return false;
        }
    }
    return num;
}
