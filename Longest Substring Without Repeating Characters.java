/*
Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
For "bbbbb" the longest substring is "b", with the length of 1.

Solution: sliding window. 2 pointers, one for the start, the other is runner. Time: O(n)
*/

public int lengthOfLongestSubstringIntMap(String s) {
    if (s.length() == 0) return 0;
    int[] mem = new int[256];
    Arrays.fill(mem, -1);
    mem[s.charAt(0)] = 0;
    int start = 0;
    int i = 1;
    int length = 1;
    for (; i< s.length(); i++){
        if (mem[s.charAt(i)] >=start){
            start = mem[s.charAt(i)] + 1;
        }
        mem[s.charAt(i)] = i;
        length = Math.max(length, i - start + 1);
    }
    return length;
}

    public int lengthOfLongestSubstringBoolMap(String s) {
        if(s.length() == 0) return 0;
        int res = 1;
        int start = 0;
        boolean[] mem = new boolean[256];
        mem[s.charAt(0)] = true;
        for(int i = 1; i < s.length(); i++){
            if(!mem[s.charAt(i)]){
                mem[s.charAt(i)] = true;
            }else{
                int temp = (i-start);
                res = Math.max(res, temp);
                //update new start, flip previous record
                for(; start < i; start++){
                    if(s.charAt(start) != s.charAt(i)){
                        mem[s.charAt(start)] = false;
                    }else{
                        start += 1;
                        break;
                    }
                }
            }
        }
        res = Math.max(res, s.length() - start);
        return res;
        
    }
