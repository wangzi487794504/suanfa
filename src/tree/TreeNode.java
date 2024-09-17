package tree;

/**
 * ClassName:TreeNode
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/7 20:30
 * @Version 1.0
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
