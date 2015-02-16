/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].


*/
public List<List<Integer>> permuteUnique(int[] num) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (num.length == 0) return res;
    
    Arrays.sort(num);
    int len = num.length;
    boolean[] visited = new boolean[len];
    List<Integer> ele = new ArrayList<Integer>();
    
    helper(res, ele, visited, num, len);
    return res;
}
private void helper(List<List<Integer>> res, List<Integer> ele, boolean[] visited, int[] num, int len){
    if (ele.size() == len){
        res.add(new ArrayList<Integer>(ele));
        return;
    }
    for (int i = 0; i<len; i++){
        //if (visited[i] || (i>0 && num[i-1] == num[i] && visited[i-1])) continue;
        if (!visited[i]){
            visited[i] = true;
            ele.add(num[i]);
            helper(res, ele, visited, num, len);
            ele.remove(ele.size() - 1);
            visited[i] = false;
            while (i< len-1 && num[i] == num[i+1]){
                i++;
            }
        }
    }
}
