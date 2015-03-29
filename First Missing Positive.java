/*
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.

Solution: if we can do it without time limitation, we can use sort and scan to solve this problem. O(nlogn)
          O(n) solution: kind of like bucket sort. A[0] = 1; A[1] = 2; ... A[index] = index+1. then scan from the beginning
                         to find the first element which is not A[index] != index+1
*/

public int firstMissingPositive(int[] A) {
    if (A.length == 0 ) return 1;
    
    for (int i = 0; i<A.length; i++){
        if (A[i] > 0 && A[i] <= A.length && A[A[i]-1]!=A[i]){
            swap(A, i, A[i]-1);
        }
    }
    
    for (int i = 0; i< A.length; i++){
        if (A[i]!= i+1){
            return i+1;
        }
    }
    return A.length + 1;
}

private void swap (int[] A, int in1, int in2){
    int temp = A[in1];
    A[in1] = A[in2];
    A[in2] = temp;
}
