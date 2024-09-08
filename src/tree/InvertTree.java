package tree;

/**
 * ClassName:InvertTree
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/8 15:29
 * @Version 1.0
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return root;
        }
        TreeNode temp=root.right;
        root.right=root.left;
        root.left=temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
