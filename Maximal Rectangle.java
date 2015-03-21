/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.

Solution:   1. Brute force: topleft corner. scan column by column; row by row. adjust minWidth from previous column
            2. Follow up based on Largest rectangle in histogram graph. 
                1 DP for histogram graph; then largest rectangle in histogram graph
                O(n^2)
          


*/
    public int maximalRectangle_BruteForce(char[][] matrix) {
        if(matrix.length == 0)  return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    int curMax = curMaxRect(matrix, i, j);
                    res = Math.max(res, curMax);
                }
            }
        }
        
        return res;
    }
    
    private int curMaxRect(char[][] matrix, int row, int col){
        //from topleft. column by column; row by row
        int max = 0;
        int minWidth = Integer.MAX_VALUE;
        for (int i = row; i < matrix.length && matrix[i][col] == '1'; i++){
            //column by column
            //int width = 0;
            int j = col;
            for (; j <matrix[0].length && matrix[i][j] == '1'; j++);
            j--;
            int width = j - col + 1;
            minWidth = Math.min(minWidth, width);
            
            int temp = (i - row + 1) * minWidth;
            max = Math.max(max, temp);
        }
        return max;
    }


public int maximalRectangle_Optimal(char[][] matrix) {
    if(matrix.length == 0|| matrix[0].length == 0) return 0;
    int[] height = new int[matrix[0].length;
    
    int res = 0;
    for(int i = 0; i<matrix.length; i++){
        for (int j = 0; j<matrix[0].length; j++){
            if (matrix[i][j] =='1'){
                height[j] +=1;
            }else{
                height[j] = 0;
            }
        }
        
        //largest area in histogram 
        int curMax = largestArea(height);
        res = Math.max(res, curMax);
    }
    return res;
}

private int largestArea(int[] height){
    Stack<Integer> stack = new Stack<Integer>();
    int res = 0;
    int i = 0;
    
    while (i <height.length){
        if (stack.empty() || height[stack.peek()] < height[i]){
            stack.push(i);
            i++;
        }else{
            int curHeight = height[stack.pop()];
            int width = stack.empty()? i: (i - stack.peek()-1);
            res = Math.max(res, curHeight * width);
        }
    }
    
    while (!stack.empty()){
        int curHeight = height[stack.pop()];
        int width = stack.empty()? height.length: (height.length - stack.peek()-1);
        res = Math.max(res, curHeight * width);
    }
    return res;
}
