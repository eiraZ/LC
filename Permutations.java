/*
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

Solution: DFS
*/
public List<List<Integer>> permute(int[] num) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (num.length == 0) return res;
    
    List<Integer> ele = new ArrayList<Integer>();
    boolean[] visited = new boolean[num.length];
    int len = num.length;
    
    helper(res, ele, num, len, visited);
    
    return res;
}
private void helper(List<List<Integer>> res, List<Integer> ele, int[] num, int len, boolean[] visited){
    if (ele.size() == len){
        res.add(new ArrayList<Integer>(ele));
        return;
    }
    for (int i = 0; i < len; i++){
        if (!visited[i]){
            visited[i] = true;
            ele.add(num[i]);
            helper(res, ele, num, len, visited);
            ele.remove(ele.size() - 1);
            visited[i] = false;
        }
    }
}
