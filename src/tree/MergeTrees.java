package tree;

/**
 * ClassName:MergeTrees
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/10 9:41
 * @Version 1.0
 */
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //TODO 先序遍历，相等的地方相加
        //返回treenode一般都是递归
        return backTracking(root1, root2);
    }
    TreeNode backTracking(TreeNode root1, TreeNode root2){
        if (root1==null && root2==null){
            return null;
        }
        else if (root1==null && root2!=null){
            root1=new TreeNode(root2.val);
        }
        else if (root2==null){
            return root1;
        }
        else {
            root1.val=root1.val+ root2.val;
        }
        System.out.println(root1);
        if (root1.left==null || root1.right==null){
            root1.left=new TreeNode();
            root1.right=new TreeNode();
        }
        //不能出现null.left
        root1.left=backTracking(root1.left, root2.left);
        root1.right=backTracking(root1.right, root2.right);
        return root1;
    }
}
