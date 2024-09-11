package tree;

/**
 * ClassName:TrimBST
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/11 9:55
 * @Version 1.0
 */
public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        //思路，还是遍历左右
        //情况一：在这个区间
        //情况二：小于这个区间
        //情况三：大于这个区间
        if (root==null){
            return null;
        }
        if (root.val>=low && root.val<=high){
            root.left=trimBST(root.left, low, high);
            root.right=trimBST(root.right, low, high);
            return root;
        }
        else if (root.val<low){
            root=trimBST(root.right, low, high);
            return root;
        }
        else {
            root=trimBST(root.left, low, high);
            return root;
        }
    }
}
