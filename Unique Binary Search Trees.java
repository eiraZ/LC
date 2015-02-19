/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 
 Solution: DP. Subproblem: # of unique bst with i nodes. 
               subtree nodes: i-1. if left has k nodes, then right has i-1-k nodes
               0<= k <= i-1
               this is a problem we've solved.
                
  
*/

public int numTrees(int n) {
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
