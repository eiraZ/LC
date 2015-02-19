/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Solution: DP. f(n) = f(n-1) + f(n-2). f(1) = 1, f(2) = 2 or f(0) = 1
            fibonacci
*/

public int climbStairs(int n) {
    if (n <= 0) return 0;
    int[] res = new int[2];
    res[0] = 1;
    res[1] = 1;
    for (int i = 2; i<=n; i++){
        int cur = res[0] + res[1];
        res[0] = res[1];
        res[1] = cur;
        
    }
    return res[1];

}
