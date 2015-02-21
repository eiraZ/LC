/*The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

Solution: iteration.
*/
public String countAndSay(int n) {
    if (n <=0) return "";
    int i = 2;
    String temp = "1";
    while( i <=n ){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char pre = temp.charAt(0);
        int in = 1;
        while(in < temp.length()){
            if (temp.charAt(in) == pre){
                count++;
            }else{
                sb.append(count);
                sb.append(pre);
                count = 1;
                pre = temp.charAt(in);
            }
            in++;
        }
        sb.append(count);
        sb.append(pre);
        
        temp = sb.toString();
        i++;
    }
    return temp;
}
