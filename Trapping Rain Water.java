/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water 
it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

Solution: 
          (1) find left bar, right bar in two scans. barHeight = Math.min(leftBar, rightBar) Time: O(n)
          (2) greedy algo: 2 pointers: one is at the beginning, one is at the end. always move the lower bar. 
          (3) stack: containing the index of decreasing height. pop once current height is larger the height in stack, 
                    height: Math.min(A[stack.peek()], A[i])
*/
public int trap_1(int[] A) {
    if (A.length == 0) return 0;
    
    int res = 0;
    
    int[] barHeight = new int[A.length];
    
    barHeight[0] = A[0];
    //find leftBar[i]
    for (int i = 1; i< A.length; i++){
        barHeight[i] = Math.max(barHeight[i-1], A[i]);
    }
    
    int right = A[A.length-1];
    for (int i = A.length-2; i>=0; i--){
        //find rightBar[i]: right
        right = Math.max(right, A[i]);
        barHeight[i] = Math.min(barHeight[i], right);
        //calculate water
        res += (barHeight[i] - A[i] > 0)? (barHeight[i] - A[i]): 0;
    }
    return res;
}

public int trap_greedy(int[] A) {
    if (A.length == 0 ) return 0;
    int left = 0; 
    int right = A.length - 1;
    
    int res = 0;
    int leftMax = A[left];
    int rightMax = A[right];
    while (left <= right){
        if(leftMax < rightMax){
            res += Math.max(0, leftMax - A[left]);
            leftMax = Math.max(leftMax, A[left]); 
            left++;
        }else{
            res += Math.max(0, rightMax - A[right]);
            rightMax = Math.max(rightMax, A[right]);
            right--;
        }
    }
    
    return res;
}

public int trap_stack(int[] A) {
    if (A.length == 0 ) return 0;
    
    Stack<Integer> stack = new Stack<Integer>();
    int i = 0;
    int res = 0;
    while (i < A.length){
        if (stack.isEmpty() || A[i] < A[stack.peek()]){
            stack.push(i);
            i++;
        }else{
            int idx = stack.pop();
            int container = (stack.isEmpty())? 0: (Math.min(A[i], A[stack.peek()]) - A[idx]) *(i - stack.peek() - 1);
            res += container;
        }
    }
    return res;
}
