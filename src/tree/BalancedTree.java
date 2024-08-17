package tree;

/**
 * ClassName:BalancedTree
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/7/16 15:12
 * @Version 1.0
 */
public class BalancedTree {
    public static boolean isBalanced(TreeNode root) {
        //递归查询
        //终止条件
        //单个循环
        int leftHegiht=maxDepth(root);
        if (leftHegiht==-1){
            return false;
        }
        return true;
    }
    //计算深度
    public static int maxDepth(TreeNode root) {
        //思路，使用递归
        //确定终止条件
        if (root==null){
            return 0;
        }
        //循环体
        int leftheight=maxDepth(root.left);
        if (leftheight==-1){
            return -1;
        }
        int rightheight=maxDepth(root.right);
        //结果：比较左子树和右子树哪一个节点比较深
        if (rightheight==-1){
            return -1;
        }
        if (Math.abs(rightheight-leftheight)>1){
            return -1;
        }
        return 1+Math.max(leftheight,rightheight);
    }
}
