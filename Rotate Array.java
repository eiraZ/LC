/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

Solution: 1. extra k sapce: copy last k elements in a new array, and move.
          2. reverse first part, reverse second part. reverse the whole part
          3. find pivot for every rotate: 2 pointers, if front == pivot && j<nums.length, then pivot = j; 
                                                      if back == n, then j = pivot
              write some examples:
              1, 2, 3, 4, 5, 6, 7 k = 3
              pivot index= 4
              swap: 5, 6, 7, 4, 1, 2, 3  j==n, adjust j = pivot==4
              swap: 5, 6, 7, 1, 4, 2, 3  i==pivot, adjust pivot = j == 5
              ......
*/

public void rotateKspace(int[] nums, int k) {
        if (k <= 0|| nums.length == 0) return;
        k = k % nums.length;
        
        int[] copy = new int[k];
        int n = nums.length;
        int idx = 0;
        //copy
        for(int i = n-k; i< n; i++){
            copy[idx] = nums[i];
            idx++;
        }
        //move
        idx = n-1;
        for(int i = n-k-1; i >=0; i--){
            nums[idx] = nums[i];
            idx--;
        }
        //add
        for (int i = 0; i <=idx; i++){
            nums[i] = copy[i];
        }
    }
  public void rotate3Reverses(int[] nums, int k) {  
        if (k <= 0|| nums.length == 0) return;
        
        k = k % nums.length;
        int n = nums.length; 
        
        helper(nums, 0, n-k-1);
        helper(nums, n-k, n-1);
        helper(nums, 0, n-1);
        
    }
    private void helper(int[] nums, int left, int right){
        for (; left < right; left++, right--){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
    
  
  public void rotatePivot(int[] nums, int k) {  
        if (k <= 0|| nums.length == 0) return;
        
        k = k % nums.length;
        if(k ==0)   return;
        int n = nums.length; 
        
        int pivot = n - k;
        int i = 0, j = pivot;
        while (i != j){
            swap(nums, i, j);
            i++;
            j++;
            if (i == pivot && j < n){
                pivot = j;
            }
            if(j == n){
                j = pivot;
            }
        }
  }
  
  private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
