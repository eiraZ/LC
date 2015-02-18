/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?


*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public void recoverTree(TreeNode root) {
    if (root == null) return;
    List<TreeNode> res = new ArrayList<TreeNode>();
    inorder(root,res);
    
    List<TreeNode> swapList = new ArrayList<TreeNode>();
    for(int i = 0; i< res.size() - 1; i++){
        if (res.get(i).val > res.get(i+1).val){
            if (swapList.size()== 0){
                swapList.add(res.get(i));
                swapList.add(res.get(i+1));
            }else{
                swapList.set(1, res.get(i+1));
            }
        }
    }
    
    int temp = swapList.get(0).val;
    swapList.get(0).val = swapList.get(1).val;
    swapList.get(1).val = temp;
    
}
private void inorder(TreeNode root, List<TreeNode> res){
    if (root == null) return;
    inorder(root.left, res);
    res.add(root);
    inorder(root.right, res);
}
