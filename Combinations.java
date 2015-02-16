/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

Solution: DFS
*/
public List<List<Integer>> combinations(int n, int k){
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (n < k) return res;
    List<Integer> ele = new ArrayList<Integer>();
    helper(res, ele, n, k, 1);
    return res;
}

private void helper(List<List<Integer>> res, List<Integer> ele, int n, int k, int start){
    if (ele.size() == k){
        res.add(new ArrayList<Integer>(ele));
        return;
    }
    
    for (int i = start; i<=n; i++){
        ele.add(i);
        helper(res, ele, n, k, i+1);
        ele.remove(ele.size()-1);
    }
    
}
