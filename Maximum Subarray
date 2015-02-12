/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

Solution: (1) brute force: find the maximum subarray one by one. O(n^2)
          (2) divide and conquer: left half, right half, max subarray contains middle element. O(nlogn)
          (3) DP. O(n)
*/
 public int maxSubArray_BF(int[] A) {
    if (A.length == 0) return Integer.MIN_VALUE;
    int res = A[0];
    for (int i = 0; i < A.length; i++){
        int sum = A[i];
        res = Math.max(sum, res);
        for (int j = i+1; j<A.length; j++){
            sum += A[j];
            if (sum > res){
                res = sum;
            }
        }
    }
    return res;
 }
 
 public int maxSubArray_DC(int[] A){
    if (A.length == 0) return Integer.MIN_VALUE;
    return maxSubArrayHelper(A, 0, A.length - 1, Integer.MIN_VALUE);
 }
 
 private int maxSubArrayHelper(int[] A, int left, int right, int maxSum){
    if (left > right ) return Integer.MIN_VALUE;
    if (left == right) return A[left];
    
    int mid = (left + right)/2;
    int leftMaxSum = maxSubArrayHelper(A, left, mid-1, maxSum);
    int rightMaxSum = maxSubArrayHelper(A, mid+1, right, maxSum);
    
    maxSum = Math.max(maxSum, Math.max(leftMaxSum, rightMaxSum));
    
    int sum = 0;
    int midLeftMax = 0;
    for (int i = mid-1; i>=left; i--){
        sum += A[i];
        midLeftMax = Math.max(midLeftMax, sum);
    }
    
    sum = 0;
    int midRightMax = 0;
    for (int i = mid+1; i<=right; i++){
        sum += A[i];
        midRightMax = Math.max(midRightMax, sum);
    }
    
    int maxSum = Math.max(maxSum, midLeftMax + A[mid] + midRightMax);
    return maxSum;
 }
 
 public int maxSubArray_DP(int[] A){
    if (A.length == 0 ) return Integer.MIN_VALUE;
    int cur = A[0];
    int global = A[0];
    for (int i = 1; i <A.length; i++){
        cur = Math.max(cur + A[i], A[i]);
        global = Math.max(res, cur);
    }
    return global;
 }
