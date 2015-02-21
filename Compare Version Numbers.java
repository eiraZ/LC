/*
Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second 
first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Solution: 2 pointers. let comparing number be long type in case of overflow. corner case: "1.0.0" "1"
*/
 public int compareVersion(String version1, String version2) {
    if (version1.length() == 0 && version2.length()==0) return 0;
    if (version1.length() == 0) return -1;
    if (version2.length() == 0) return 1;
    
    int in1 = 0;
    int in2 = 0;
    int len1 = version1.length();
    int len2 = version2.length();
    while(in1 < len1 || in2 < len2){
        long temp1 = 0;
        long temp2 = 0;
        while(in1<len1 && version1.charAt(in1)!= '.'){
            temp1 = temp1 * 10 + (version1.charAt(in1) - '0');
            in1++;
        }
        in1++;
        
        while(in2 < len2 && version2.charAt(in2)!= '.'){
            temp2 = temp2 * 10 + (version2.charAt(in2) - '0');
            in2++;
        }
        in2++;
        
        if(temp1 > temp2){
            return 1;
        }else if(temp1 < temp2){
            return -1;
        }
    }
    return 0;
 }
