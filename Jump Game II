/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/
public int jump(int[] A) {
    if (A.length == 0 ) return 0;
    int preReach = 0;
    int reach = A[0];
    for (int i = 1; i < A.length && i <=reach; i++){
        if (i>preReach){
            step++;
            preReach = reach;
            if (reach >= A.length - 1) return step;
        }
        reach = Math.max(reach, A[i] + i);
    }
    return 0;
}
