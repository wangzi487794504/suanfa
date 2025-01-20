package fuxi;

import sort.BubbleSort;
import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName:Test4
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/10/4 21:25
 * @Version 1.0
 */
public class Test5 {
//    List<List<Integer>> lists=new ArrayList<>();
    public TreeNode rob(TreeNode root) {
        //递归
        if (root==null){
            return root;
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        rob(root.left);
        rob(root.right);
        return root;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null) {
            return false;
        }
        else if (p != null && q == null) {
            return false;
        }
        else if (p == null && q == null) {
            return true;
        }
        else {
            if (p.val!=q.val){
                return false;
            }
            boolean sameTree = isSameTree(p.left, q.left);
            boolean sameTree1 = isSameTree(p.right, q.right);
            return sameTree1&&sameTree;
        }

    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root== null && subRoot !=null){
            return false;
        }
        if (root==null && subRoot==null){
            return true;
        }
        if (root!=null && subRoot==null){
            return false;
        }
        else{
                return isSametree(root, subRoot) || isSubtree(root.left, subRoot) ||isSubtree(root.right, subRoot);
        }
    }
    public boolean isSametree(TreeNode root, TreeNode subRoot) {
        if (root== null && subRoot !=null){
            return false;
        }
        if (root==null && subRoot==null){
            return true;
        }
        if (root!=null && subRoot==null){
            return false;
        }
        else{
            boolean result=false;
            if (root.val==subRoot.val){
                boolean sameTree = isSubtree(root.left, subRoot.left);
                boolean sameTree1 = isSubtree(root.right, subRoot.right);
                //三种情况有一种成立
                return result;
            }
            boolean sameTree = isSubtree(root.left, subRoot);
            boolean sameTree1 = isSubtree(root.right, subRoot);
            //三种情况有一种成立
            return (sameTree1 || sameTree) || result;
        }
    }
    //


}
