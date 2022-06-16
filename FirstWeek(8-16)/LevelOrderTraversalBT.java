/*

	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T val;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

*/

import java.util.*;

public class Solution {

  public static ArrayList<Integer> getLevelOrder(BinaryTreeNode root) {
    //Your code goes here
      
      
      ArrayList<Integer> res = new ArrayList<>();
      if(root == null) return res;
      Queue<BinaryTreeNode> q = new LinkedList<>();
      q.add(root);
     
      while(!q.isEmpty())
      {
          BinaryTreeNode node = q.poll();
          if(node.val != -1) res.add(node.val);
          if(node.left!=null)
              q.add(node.left);
          if(node.right!=null)
              q.add(node.right);
      }
      
      return res;
  }

}


/*LEETCODE*/

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
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      
        
      if(root == null) return res;
      Queue<TreeNode> q = new LinkedList<>();
      q.add(root);
     
      while(!q.isEmpty())
      {
          int s = q.size();
          List<Integer> al = new ArrayList<>();
          for(int i=0;i<s;i++)
          {
          TreeNode node = q.poll();
          al.add(node.val);
          if(node.left!=null)
              q.add(node.left);
          if(node.right!=null)
              q.add(node.right);
          }
          
          res.add(al);
      }
      
      return res;
    }
}