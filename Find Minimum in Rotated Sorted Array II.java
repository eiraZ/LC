/*
Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
Solution: find monotonic increasing sequence, if we encounter ==, move pointers
        Worst case: O(n)
*/

public int findMin_leftAsMin(int[] num) {
    if (num == null || num.length == 0 ) return Integer.MIN_VALUE;
    int left = 0;
    int right = num.length - 1;
    
    while ( left <= right && num[left] > num[right]){
        int mid = (left+right)/2;
        if ( num[mid] < num[right]){    //mid -> right: increasing
            right = mid;
        }else if (num[mid] > num[right]){ 
        //left->mid : increasing. and we know num[left]>num[right], min value must be in [mid+1, right]
            left = mid + 1;
        }else{
        //num[mid] == num[right]
            left++;
        }
    }
    return num[left];
}

public int findMin_updateFromI(int[] num) {
    if(num==null||num.length==0){
        return Integer.MAX_VALUE;
    }
        
    int left = 0;
    int right = num.length - 1;
    int min = num[0];
    while (left <= right){
        int mid = (int) (left + right)/2;
        if(num[mid]==num[left]){
            min = Math.min(num[left], min);
            left++;
        }else if (num[left] < num[mid]){   //left -> mid : ascending order
            min = Math.min(num[left], min);
            left = mid + 1;
        }else{
            min = Math.min(num[mid], min);
            right = mid - 1;
        }
    }
    return min;
}
