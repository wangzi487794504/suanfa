package tree;

/**
 * ClassName:SumOfLeftLeaves
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/8 21:06
 * @Version 1.0
 */
public class SumOfLeftLeaves {
    int sum=0;
    //遍历，只要左节点不为空就加
    public int sumOfLeftLeaves(TreeNode root) {
        backtracking(root, false);
        return sum;
    }
    void backtracking(TreeNode root,boolean flag){
        if (root.left==null && root.right==null && flag==true){
            sum+= root.val;
            return;
        }
        if (root.left!=null){
            backtracking(root.left, true);
        }
        if (root.right!=null){
            backtracking(root.right, false);
        }
    }
}
