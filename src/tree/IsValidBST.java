package tree;

/**
 * ClassName:IsValidBST
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/10 10:33
 * @Version 1.0
 */
public class IsValidBST {
    TreeNode preNode=null;
    public boolean isValidBST(TreeNode root) {
        if (root==null ){
            return true;
        }
        //使用中序遍历，左中右是一个递增，使用一个指针指向上一个指针，如果大才对
        //左节点
        boolean left = isValidBST(root.left);
        //比较中
        if (preNode!=null && preNode.val>=root.val){
            return false;
        }
        preNode=root;
        boolean right = isValidBST(root.right);
        return left && right;
    }
}
