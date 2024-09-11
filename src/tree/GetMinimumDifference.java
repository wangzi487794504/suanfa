package tree;

/**
 * ClassName:GetMinimumDifference
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/10 14:47
 * @Version 1.0
 */
public class GetMinimumDifference {
    int result=Integer.MAX_VALUE;
    TreeNode temp=null;
    public int getMinimumDifference(TreeNode root) {
        //中序排序
        //保留最小差值
        if (root==null){
            return Integer.MAX_VALUE;
        }
        //左递归
        getMinimumDifference(root.left);
        if (temp!=null && root.val- temp.val<result){
            result=root.val- temp.val;
        }
        temp=root;
        //todo 右节点
        getMinimumDifference(root.right);
        return result;
    }
}
