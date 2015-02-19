/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
  Solution: 1. DFS
        substring -> check -> yes: next
                            no : <--
        
        or we can get a palindrome dictionary first: dic[start][end] is a palindrome or not
        2. DP + HashMap. HashMap<Integer, List<String>> map . Key: from ith char value: palindrome list from ith char
          palindrome always exists starting from every character
        
*/
public List<List<String>> partition(String s) {
    List<List<String>> res = new ArrayList<List<String>>();
    
    if(s.length() == 0) return res;
    List<String> ele = new ArrayList<String>();
    
    partitionHelper(res, ele, s);
    return res;
}

private void partitionHelper(List<List<String>> res, List<String> ele, String s){
    if (s.length() == 0){
        res.add(new ArrayList<String>(ele));
        return;
    }
    for (int len = 1; len <= s.length(); len++){
        String temp = s.substring(0, len);
        if (isPalindrome(temp)){
            ele.add(temp);
            partitionHelper(res, ele, s.substring(len));
            ele.remove(ele.size() - 1);
        }
    }
}
// or use DP to get every palindrome
private boolean isPalindrome(String str){
    if (str.length() == 0) return true;
    String temp = str.toLowerCase();
    int left = 0;
    int right = temp.length() - 1;
    while (left < right){
        if(temp.charAt(left) != temp.charAt(right)){
            return false;
        }
        left++;
        right--;
    }
    return true;
}

public List<List<String>> partition_Dict(String s) {
    List<List<String>> res = new ArrayList<List<String>>();
    
    if(s.length() == 0) return res;
    List<String> ele = new ArrayList<String>();
    boolean[] dict = palinDict(str);
    helper(res, ele, s, dict, 0);
    return res;
    
}
private void helper(List<List<String>> res, List<String> ele, String s, boolean[][] dict, int start){
    if (start == s.length()){
        res.add(new ArrayList<String>(ele));
        return;
    }
    for (int end = start; end < s.length(); end++){
        if(dict[start][end]){
            ele.add(s.substring(start, end+1);
            helper(res, ele, s, dict, end+1);
            ele.remove(ele.size()-1);
        }
    }
}

private boolean[][] palinDict(String str){
    boolean[][] res = new boolean[str.length()][str.length()];
    // res[i][j] <- (res[i+1][j-1] || j-i<=2) && str.charAt(i) == str.charAt(j)
    
    for (int i = str.length()-1; i>=0; i--){
        for (int j = i; j < str.length(); j++){
            if( str.charAt(i) == str.charAt(j) && (j-i<=2 || res[i+1][j-1])){
                res[i][j] = true;
            }
        }
    }
    return res;
}


//----------------------------------------------------------------------------
    public List<List<String>> partitionMap(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (s.length() == 0) return res;
        Map<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();
    
        boolean[][] dict = new boolean[s.length()][s.length()];
    
        int len = s.length();
        for (int i = len - 1; i>=0; i--){
            List<List<String>> ipalin = new ArrayList<List<String>>();
            for (int j = i; j < len; j++){
                if (s.charAt(i) == s.charAt(j) &&( j-i <= 2 || dict[i+1][j-1])){
                    dict[i][j] = true;
                    String p = s.substring(i, j+1);
                    if (map.containsKey(j+1)){
                        for(List<String> list: map.get(j+1)){
                            List<String> temp = new ArrayList<String>(list);
                            temp.add(0, p);
                            ipalin.add(temp);
                        }
                    }else{
                        List<String> list = new ArrayList<String>();
                        list.add(0, p);
                        ipalin.add(list);
                    }
                
                }
            }
            map.put(i, ipalin);
        }
        return map.get(0);
    }
