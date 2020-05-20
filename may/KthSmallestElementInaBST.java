/* Kth Smallest Element in a BST
* Solution
* Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
* 
* Note:
* You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
* 
* Example 1:
* 
* Input: root = [3,1,4,null,2], k = 1
*    3
*   / \
*  1   4
*   \
*    2
* Output: 1
* Example 2:
* 
* Input: root = [5,3,6,2,4,null,null,1], k = 3
*        5
*       / \
*      3   6
*     / \
*    2   4
*   /
*  1
* Output: 3
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    ArrayList<Integer> elementsIncOrd ;

    void elementsIncOrdReset()
    {
        this.elementsIncOrd = new <Integer>ArrayList();
    }
    void Inorder(TreeNode root,int k)
    {
        if(root!=null && this.elementsIncOrd.size()<k)
        {
            Inorder(root.left,k);
            this.elementsIncOrd.add(root.val);
            Inorder(root.right,k);
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        elementsIncOrdReset();
        Inorder(root,k);
        return this.elementsIncOrd.get(k-1);
    }
}