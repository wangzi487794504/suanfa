package dynamic;

import tree.TreeNode;

/**
 * ClassName:Rob3
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/14 19:54
 * @Version 1.0
 */
public class Rob3 {
    public int rob(TreeNode root) {
        if (root==null){
            return 0;
        }
        if (root.left==null&& root.right==null){
            return root.val;
        }
        if (root.left!=null){

        }
        if (root.right!=null){
            rob(root.right);
        }
        return 0;
    }
}
