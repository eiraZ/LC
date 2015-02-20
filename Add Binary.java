/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

*/
public String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int index1 = a.length() - 1;
    int index2 = b.length() - 1;
    
    int carry = 0;
    while(index1 >=0 || index2 >=0|| carry > 0){
        int temp = carry;
        int digitA =0;
        if(index1 >= 0){
            temp += a.charAt(index1) - '0';
            index1--;
        }if (index2 >=0){
            temp += b.charAt(index2) - '0';
            index2--;
        }
        sb.insert(0, temp%2);
        carry = temp/2;
    }
    return sb.toString();
    
    
}
