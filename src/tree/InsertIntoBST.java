package tree;

/**
 * ClassName:InsertIntoBST
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/10 21:29
 * @Version 1.0
 */
public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //遍历root，可以比较根，也可以左中右递增遍历
        if (root==null){
            return null;
        }
        //比较大小，选择是左子树还是右子树
        //退出循环的条件
        if (root.val<val && root.left==null){
            root.left=new TreeNode(val);
        }
        if (root.val>val && root.right==null){
            root.right=new TreeNode(val);
        }
        if (root.val<val && root.right!=null){
            insertIntoBST(root.right, val);
        }
        else {
            insertIntoBST(root.left, val);
        }
        return root;
    }
}
