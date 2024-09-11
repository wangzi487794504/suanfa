package tree;

/**
 * ClassName:ConvertBST
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/11 15:59
 * @Version 1.0
 */
public class ConvertBST {
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        //遍历放在一个数组中，然后相加之后求出他的结果再构造树
        //找规律：先遍历右边，再遍历根，再遍历左边
        //右边的转成他和它的右子树之和
        if (root==null){
            return null;
        }
        convertBST(root.right);
        root.val= root.val+sum;
        sum= root.val;
        //还得回溯
        convertBST(root.left);
        return root;
    }
}
