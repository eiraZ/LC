/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers
sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 

Solution: DFS

*/
public List<List<Integer>> combinationSum(int[] num, int target){
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (num.length == 0 || target <=0)  return res;
    
    Arrays.sort(num);
    List<Integer> ele = new ArrayList<Integer>();
    helper(res, ele, num, target, 0);
    return res;
}
private void helper(List<List<Integer>> res, List<Integer> ele, int[] num, int target, int start){
    if (target == 0){
        res.add(new ArrayList<Integer>(ele));
        return;
    }
    for (int i = start; i < num.length && num[i] <= target; i++){
        ele.add(num[i]);
        helper(res, ele, num, target-num[i], i);
        ele.remove(ele.size() - 1);
    }
}
