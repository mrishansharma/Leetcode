/* Cousins in Binary Tree
* Solution
* In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
* 
* Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
* 
* We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
* 
* Return true if and only if the nodes corresponding to the values x and y are cousins.
* 
* Example 1:
* Input: root = [1,2,3,4], x = 4, y = 3
* Output: false
* Example 2:
* Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
* Output: true
* Example 3:
* Input: root = [1,2,3,null,4], x = 2, y = 3
* Output: false
* Note:
* The number of nodes in the tree will be between 2 and 100.
* Each node has a unique integer value from 1 to 100.
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
    boolean areSiblings(TreeNode root, int x, int y)
    {
        if(root==null) return false;
        if(root.left!=null && root.right!=null)
        {
            if((root.left.val == x && root.right.val == y)||(root.left.val == y && root.right.val == x))
            {return true;}
        }
        boolean areSib = areSiblings(root.left, x,y);
        if(!areSib) areSib = areSiblings(root.right,x,y);
        return areSib;
    }
    int depth(TreeNode root , int x , int dep)
    {
        if(root == null) return -1;
        if(root.val == x) return dep+1;
        int ans = depth(root.left,x,dep+1);
        if(ans == -1) ans = depth(root.right,x,dep+1);
        return ans;
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        boolean areSib =  areSiblings(root,x,y);
        if(!areSib)
        {
            int depth_x= -1;
            int depth_y = -1;
            depth_x = depth(root,x,-1);
            depth_y = depth(root,y,-1);
            if(depth_x == depth_y)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}