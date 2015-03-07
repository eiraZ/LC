/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
Solution: (1) 2 pointers. one is for counting 0, the other is for counting 2. traverse once
              similar thoughts: 
                    0: [0, l); 
                    1: [l, r); 
                    2: [r, c)
                    now we want to sort [c, n) in order.
                    initial: l = 0, r = 0, c = 0;
                    constraints: l <=r <=c 
                    stop: c==n
          (2) counting sort. we know the range is [0, 2], build a 3-length array for counting. traverse twice.
*/

    public void sortColors_2pointers(int[] A) {
        /* quick-sort: partition
           left: 0; right: 2
        */
        
        if(A.length<=1) return;
        
        for (int i=0, left = 0, right = A.length-1; i<=right; ){
            if (A[i]==0){
                A[i++] = A[left];
                //A[i] = A[left];
                //i++;
                A[left++] = 0;
            }else if (A[i] == 2){
                A[i] = A[right];
                A[right--] = 2;
            }else{
                i++;
            }
        }
    }
    
    public void sortColors_similar(int[] A) {
        int l = 0, r = 0, c = 0;
        int n = A.length;
        while (c < n){
            if (A[c] == 2) c++;
            else if (A[c] == 1){
                swap(A, r, c);
                r++;
                if(c < r){
                    c = r;
                }
            }else{
                swap(A, l, c);
                l++;
                if(c < l){
                    c = l;
                }
                if (r < l){
                    r = l;
                }
            }
        }
    }
    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
    public void sortColors_counting(int[] A) {
        int[] bucket = new int[3];
        for (int i = 0; i< A.length; i++){
            bucket[A[i]]++;
        }
        
        int index = 0;
        for (int i = 0; i<bucket.length; i++){
            int count = bucket[i];
            while (count >0){
                A[index] = i;
                index++;
                count--;
            }
        }

    }
    
