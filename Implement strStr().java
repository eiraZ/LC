/*
Implement strStr().
Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Solution: (1) Sliding window: two pointers, one is for start, the other is the runner. 
          (2) Rolling hash: 
                    code = c0 * a^(k-1) + c1* a^(k-2) + c2 * a^(k-3)+... + c(k-1)* a^0. a should be a prime
                    codeNext = (code - c0 * a^(k-1)) * a + c(k) * a^0
                    code == codeNext or not.
                    if this code overflows, try to use mod n, where n is a big prime. This will generate same hash code. 
                    it is possible that two strings are the same if they have the same hash code. Time: O(n) 

*/
public int strStr_window(String haystack, String needle) {
    if (haystack.length() < needle.length()) return -1;
    if (needle ==null || needle.length() == 0) return 0;
    
    int start = 0;
    int i = 0;
    while (i <= haystack.length() - needle.length()){
        if ( haystack.charAt(i) == needle.charAt(0)){
            int j = 1;
            for (; j<needle.length() && haystack.charAt(i+j) == needle.charAt(j); j++);
            if (j ==needle.length()){
                return i;
            }
        }
        i++;
    }
    return -1;
}

public int strStr(String haystack, String needle){
    if (haystack.length() < needle.length()) return -1;
    if (needle ==null || needle.length() == 0) return 0;
    
    int hayCode = 0;
    int needleCode = 0;
    for (int i = 0; i<needle.length(); i++){
        hayCode += haystack.charAt(i);
        needleCode += needle.charAt(i);
    }
    
    int head = 0;
    int tail = needle.length() - 1;
    while ( tail < haystack.length()){
        if (hayCode == needleCode){
            int i = 0;
            for (; i < needle.length() && haystack.charAt(head+i) == needle.charAt(i); i++);
            if ( i == needle.length()) return head;
        }else{
            if (tail == haystack.length()-1) return -1;
            hayCode -= haystack.charAt(head);
            head++;
            tail++;
            hayCode += haystack.charAt(tail);
        }
    }
    return -1;
    
}

public int strStr_RK(String haystack, String needle){
        int M = haystack.length();
        int N = needle.length();
        if (M < N)  return -1;
        if(N == 0)  return 0;
        int base = 29;
        long curBase = 1;
        long hayCode = 0;
        long needleCode = 0;
        for (int i = N-1; i>=0; i--){
            needleCode += (int)needle.charAt(i) * curBase;
            curBase *= base;
        }
        curBase = 1;
        for (int i = N-1; i >=0; i--){
            hayCode += (int)haystack.charAt(i) * curBase;
            curBase *= base;
        }
        curBase /= base;
        if (hayCode == needleCode)  return 0;
        
        for (int i = N; i<M; i++){
            hayCode = (hayCode - (int)haystack.charAt(i-N) * curBase) * base + (int)haystack.charAt(i);
            if (hayCode == needleCode)  return i-N+1;
            
        }
        return -1;
}
