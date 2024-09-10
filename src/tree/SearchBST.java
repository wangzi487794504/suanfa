package tree;

/**
 * ClassName:SearchBST
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/10 10:26
 * @Version 1.0
 */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null){
            return null;
        }
        if (root.val==val){
            return root;
        }
        if(root.val<val){
            return searchBST(root.right, val);
        }
        else {
            return searchBST(root.left, val);
        }
    }
}
