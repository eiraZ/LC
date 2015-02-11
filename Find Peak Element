/*
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

Solution: (1) traverse once. compare A[i-1], A[i], and A[i+1]. bound check! O(n)
          (2) Binary search. O(logn) there always exists a peak element in an array.
*/
public int findPeakElement_BS(int[] num){
        int left = 0;
        int right = num.length - 1;
        int mid = -1;
        while (left<=right){
            mid = (left + right)/2;
            if((mid==0||num[mid-1]<num[mid]) && (mid==num.length-1 || num[mid]>num[mid+1])){
                return mid;
            }
            if( mid>0 && num[mid-1]>= num[mid]){
                right = mid - 1;
            }else if (mid<num.length -1 && num[mid] <= num[mid+1]){
                left = mid + 1;
            }
        }
        return mid;
}

public int findPeakElement(int[] num){
    //length ==1
    if(num.length==1){
        return 0;
    }
    //check num[0]
    if(num[0]>num[1]){
        return 0;
    }
    //check num[num.lengh-1]
    if(num[num.length-1]>num[num.length-2]){
        return num.length-1;
    }
    
    for(int i=1; i<num.length-1; i++){
        if(num[i]>num[i-1]&&num[i]>num[i+1]){
            return i;
        }
    }
    return -1;
}
