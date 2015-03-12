/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

Solution: (1) search for the lower bound and upper bound.
          (2) Think of searching the insert position. we do search(target), search(target+1). this is similar with lowerbound.
              but we need to subtract search(target+1)--;

*/
public int[] searchRange_LU(int[] A, int target) {
    int[] res = new int[2];
    res[0] = searchLowerBound(A, target);
    res[1] = searchUpperBound(A, target);
    
    if(res[0]>res[1]){
        Arrays.fill(res, -1);
    }
    return res;
}

public int[] searchRange_insert(int[] A, int target){
    int[] res = new int[2];
    res[0] = searchLowerBound(A, target);
    res[1] = searchLowerBound(A, target+1);
    res[1]--;
    if(res[0]>res[1]){
        Arrays.fill(res, -1);
    }
    return res;
    
}
private int searchLowerBound(int[] A, int target){
    if (A.length ==0) return -1;
    int left = 0;
    int right = A.length - 1;
    while (left <=right){
        int mid = (left + right)/2;
        if(A[mid] < target){
            left = mid + 1;
        }else{
            right = mid - 1;
        }
    }
    return left;
}

private int searchUpperBound(int[] A, int target){
    if (A.length ==0) return -1;
    int left = 0;
    int right = A.length - 1;
    while (left <=right){
        int mid = (left + right)/2;
        if(A[mid] <= target){
            left = mid + 1;
        }else{
            right = mid - 1;
        }
    }
    return right;
}
