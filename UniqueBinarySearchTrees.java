/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 
 Solution:  think from top to bottom. if we want to find # of BST with n nodes, consider root, # of left substrees and # of 
            right subtrees. left subtree: left subroot: 1 -> root - 1, consider null case. TLE
            DP. Subproblem: # of unique bst with i nodes. 
               subtree nodes: i-1. if left has k nodes, then right has i-1-k nodes
               0<= k <= i-1
               this is a problem we've solved.
                
  
*/
   public int numTreesRecursion(int n) {
        if (n <= 0) return 0;
        return numTreesHelper(n);
    }
    
   private int numTreesHelper(int n){
        if (n == 0) return 1;
        if (n == 1) return 1;
        int res = 0;
        for (int i = 0; i < n; i++){
            res += numTrees(i) * numTrees(n-i-1);
        }
        return res;
    }

public int numTreesDP(int n) {
        if(n<=0) return 0;
        int[] res = new int[n+1];
        res[0] = 1;
        //res[1] = 1;
        /* x nodes construct a tree: left: m, right n.  x = m + n + 1(root);
        */
        for(int i=1; i<=n; i++){
            for(int left=0; left < i; left++){
                res[i] += res[left] * res[i-1-left];
            }
        }
        
        return res[n];
    }
