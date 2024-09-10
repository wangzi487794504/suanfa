package tree;

/**
 * ClassName:HasPathSum
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/9 9:35
 * @Version 1.0
 */
public class HasPathSum {
    int sum=0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return backtracking(root, targetSum);
    }
    boolean flag=false;
    boolean backtracking(TreeNode root, int targetSum){
        //回溯法
        if (root!=null){
            sum+=root.val;
        }
        else {
            return false;
        }
        int temp=sum;
        if (root.left==null && root.right==null){
            if (sum==targetSum){
                flag=true;
                return true;
            }
            return false;
        }
        if (root.left!=null){
            backtracking(root.left, targetSum);
            //回溯
            sum=temp;
        }
        if (root.right!=null){
            backtracking(root.right,targetSum);
            sum=temp;
        }
        return flag;
    }
}
