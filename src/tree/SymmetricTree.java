package tree;


/**
 * ClassName:SymmetricTree
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/7/16 8:52
 * @Version 1.0
 */
public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        //代码思路
        //确定终止条件
        return compare(root.left, root.right);
    }
    public static boolean compare(TreeNode left,TreeNode right){
        if (left!=null&&right==null){
            return false;
        }
        if (right!=null&&left==null){
            return false;
        }
        if (left==null&&right==null){
            return true;
        }
        if (left.val!=right.val){
            return false;
        }
        //递归体，判断左子树的右节点是否等于右子树的左节点
        boolean flag1 = compare(left.left, right.right);
        boolean flag2 = compare(left.right, right.left);
        System.out.println(flag1&&flag2);
        return flag1&&flag2;
    }

    public static void main(String[] args) {
        CreateTree createTree = new CreateTree();
        TreeNode root = createTree.createTree(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        boolean result = isSymmetric(root);
        System.out.println(result);
    }
}
