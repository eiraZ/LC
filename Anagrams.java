/*
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.

Solution: 1. sort, and store in hashmap: assume input with length n, average length of a string is m: O(nmlgm)
          2. count # of a char appearance in a string, and compare one by one. O(m*n^2). In LC, TLE
          
          when n > lgm, choose first option. else, choose the second one.
*/

public List<String> anagrams1(String[] strs) {
    List<String> res = new ArrayList<String>();
    if(strs.length == 0) return res;
    
    HashMap<String, List<String>> map = new HashMap<String, List<String>>();
    
    for (int i = 0; i < strs.length; i++){
        char[] ch = strs[i].toCharArray();
        Arrays.sort(ch);
        if (map.containsKey(ch)){
            map.get(ch).add(strs[i]);
        }else{
            List<String> ele = new ArrayList<String>();
            ele.add(strs[i]);
            map.put(ch, ele);
        }
    }
    Iterator<List<String>> iter = map.values().iterator();
    while (iter.hasNext()){
        List<String> value = iter.next();
        if(value.size() > 1){
            res.addAll(value);
        }
    }
    
    
    /*
    Iterator<Map.Entry<String, List<String>>> iter = map.entrySet().iterator();
    while(iter.hasNext()){
        Map.Entry<String, List<String>> entry = iter.next();
        List<String> value = entry.getValue();
        if(value.size() > 1){
            res.addAll(value);
        }
        
    }
    */
    return res;
}

    public List<String> anagrams2(String[] strs) {
        List<String> res = new ArrayList<>();
        if(strs.length == 0)    return res;
        
        boolean[] used = new boolean[strs.length];
        
        for(int i = 0; i< strs.length; i++){
            if(used[i]) continue;
            
            int[] count = new int[26];
            for(int c = 0; c < strs[i].length(); c++){
                int index = strs[i].charAt(c) - 'a';
                count[index]++;
            }
            res.add(strs[i]);
            //found 
            for(int j = i+1; j < strs.length; j++){
                if(used[j]) continue;
                
                String cur = strs[j];
                int[] copy = Arrays.copyOf(count, 26);
                if(cur.length() != strs[i].length())    continue;
                
                int k = 0;
                for(; k < cur.length(); k++){
                    int index2 = cur.charAt(k) - 'a';
                    copy[index2]--;
                    if(copy[index2] < 0)    break;
                }
                
                if(k == cur.length()){
                    res.add(strs[j]);
                    used[j] = true;
                }
            }
        }
        
        return res;
        
    }
