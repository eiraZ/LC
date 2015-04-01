/*
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent
houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on
the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you
can rob tonight without alerting the police.

Solution: (1) recursion. f(n) = max(f(n-1), f(n-2) + num[n-1]), f(1) = num[0], f(0) = 0; TLE. Time: O(2^n)
          (2) DP. Time: O(n), Space: O(n) -> O(1)
*/

    public int robRecursion(int[] num) {
        if(num.length == 0) return 0;
        return helper(num, num.length);

    }
    private int helper(int[] num, int n){
        if (n == 0) return 0;
        if (n == 1) return num[0];
        return Math.max(helper(num, n-1), helper(num, n-2) + num[n-1]);
    }
    
    public int robDP(int[] num) {
        if(num.length == 0) return 0;
        //int[] res = new int[num.length + 1];
        int[] res = new int[2];
        res[0] = 0;
        res[1] = num[0];
        
        for (int i = 2; i <= num.length; i++){
            int temp = Math.max(res[1], res[0] + num[i-1]);
            res[0] = res[1];
            res[1] = temp;
            //res[i] = Math.max(res[i-1], res[i-2] + num[i-1]);
        }
        //return res[num.length];
        return res[1];
    }
    
