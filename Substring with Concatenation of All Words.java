/*
You are given a string, S, and a list of words, L, that are all of the same length. 
Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once 
and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
*/

public List<Integer> findSubstring(String S, String[] L) {
       /*
       hashmap need: store strings in L. key: String, value: # of appearance
       # of different start indice: L[0].length
       search from start till the end. cut: L[0].length() and search in need. 
            not contained. update start
            contained: need, found
       
       */
       /*
        List<Integer> res = new ArrayList<Integer>();
        if(S==null||S.length()==0||L==null||L.length==0){
            return res;
        }
        HashMap<String, Integer> need = new HashMap<String, Integer>();
        
        for (int i = 0; i< L.length; i++){
            if (!need.containsKey(L[i])){
                need.put(L[i], 1);
            }else{
                need.put(L[i], need.get(L[i]) + 1);
            }
        }
        int len = L[0].length();
        int n = L.length;
        for (int i = 0; i < len; i++){
            HashMap<String, Integer> found = new HashMap<String, Integer>();
            int count = 0;
            int start = i;
            for (int end = i; end + len <= S.length(); end += len){
                String temp = S.substring(end, end+len);
                if (!need.containsKey(temp)){
                    start = end + len;
                    found.clear();
                    count = 0;
                    continue;
                }
                while (found.containsKey(temp) && found.get(temp) >= need.get(temp)){
                    String str = S.substring(start, start+len);
                    found.put(str, found.get(str) - 1);
                    count--;
                    start += len;
                    
                }
                if (found.containsKey(temp)){
                    found.put(temp, found.get(temp)+1);
                }else{
                    found.put(temp, 1);
                }
                count++;
                if (count != n) continue;
                res.add(start);
            }
        }
        return res;
    }

public List<Integer> findSubstring(String S, String[] L) {
    List<Integer> res = new ArrayList<Integer>();
    if (S.length() == 0 || L.length == 0) return res;
    
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    for(int i = 0; i < L.length; i++){
        if(map.containsKey(L[i])){
            map.put(L[i], map.get(L[i])+1);
        }else{
            map.put(L[i], 1);
        }
    }
    
    int len = L[0].length();
    int n = L.length;
    for (int i = 0; i<=S.length() - L.length * len; i++){
        HashMap<String, Integer> found = new HashMap<String, Integer>();
        int count = 0;
        for (; count < n; count++){
            String temp = S.substring(i + count*len, i + (count+1)*len);
            if(!map.containsKey(temp)) break;
            if (found.containsKey(temp)){
                if (found.get(temp) < map.get(temp)){
                    found.put(temp, found.get(temp)+1);
                }else{
                    break;
                }
            }else{
                found.put(temp, 1);
            }
        }
        if (count == n) res.add(i);
    }
    return res;
}


//  TLE
public List<Integer> findSubstring_bf(String S, String[] L) {
    List<Integer> res = new ArrayList<Integer>();
    if (S.length() == 0 || L.length == 0) return res;
    
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    for(int i = 0; i < L.length; i++){
        if(map.containsKey(L[i])){
            map.put(L[i], map.get(L[i])+1);
        }else{
            map.put(L[i], 1);
        }
    }
    
    int count = 0;
    int len = L[0].length();
    int i = 0;
    while ( i< S.length()- (len * L.length)){
        String temp = S.substring(i, i+len);
        if(map.containsKey(temp)){
            String remain = S.substring(i+len);
            HashMap<String, Integer> countMap = new HashMap<String, Integer>(map);
            while (countMap.containsKey(temp) && countMap.get(temp) > 0){
                countMap.put(temp, map.get(temp) - 1);
                count++;
                if(count == L.length){
                    res.add(i);
                    break;
                }
                if (remain.length() >=len){
                    temp = remain.substring(0, len);
                    remain = remain.substring(len);
                }else{
                    break;
                }
            }
            count = 0;
            
        }
        i++;
    }
    return res;
}
