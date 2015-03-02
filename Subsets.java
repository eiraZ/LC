/*
Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
Solution: (1) recursion. DFS
          (2) iteration.
          (3) Bit manipulation: we have 2^(S.length) subsets in total. e.g.
             S = {1, 2, 3};
             0th = {}; 001 -> {3}; 010 ->{2}; 011->{2,3}. 
             bit "1": yes; bit 0: no.
*/
public List<List<Integer>> subsets_recursion(int[] S) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if(S.length == 0) return res;
    
    Arrays.sort(S);
    List<Integer> ele = new ArrayList<Integer>();
    helper(res, ele, S, 0);
    return res;
}

public void helper(List<List<Integer>> res, List<Integer> ele, int[] S, int start){
    List<Integer> temp = new ArrayList<Integer>(ele);
    res.add(temp);
    for (int i = start; i<S.length; i++){
        ele.add(S[i]);
        helper(res, ele, S, i+1);
        ele.remove(ele.size()-1);
    }
}

public List<List<Integer>> subsets_iteration(int[] S){
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if(S.length == 0) return res;
    
    Arrays.sort(S);
    res.add(new ArrayList<Integer>());
    
    for (int i = 0; i<S.length; i++){
        int size = res.size();
        for (int j = 0; j < size; j++){
            List<Integer> temp = new ArrayList<Integer>(res.get(j));
            temp.add(S[i]);
            res.add(temp);
        }
    }
    return res;
}

public List<List<Integer>> subsetsBit(int[] S){
  List<List<Integer>> res = new ArrayList<List<Integer>>();
  if (S.length == 0) return res;
  
  int n = S.length;
  int total = 1 << n;
  
  for (int i = 0; i< total; i++){
      List<Integer> ele = new ArrayList<Integer>();
      int pos = n - 1;
      int cur = i;
      while (cur > 0){
          if ( (cur & 1) == 1){
              ele.add(S[pos]);
          }
          cur = cur>>1;
          pos--;
      }
      Collections.sort(ele);
      res.add(ele);
  }
  return res;
}
