package tree;

/**
 * ClassName:CountNodes
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/7/16 12:37
 * @Version 1.0
 */
public class CountNodes {
    public static int count(TreeNode root){
        //方法1，递归遍历，建议采用后序遍历，因为后序遍历最后才是根节点，有利于统计左右子树节点的个数
        //todo 书写递归结束条件
        if (root==null){
            return 0;
        }
        //todo 书写单个循环代码
        //遍历左子树
        int leftCount = count(root.left);
        //遍历右子树
        int rightCount = count(root.right);
        //根节点
        int result=leftCount+rightCount+1;
        return result;
    }
    public static void main(String[] args) {
        CreateTree createTree = new CreateTree();
        TreeNode root = createTree.createTree(new Integer[]{1, 2, 2, 3, 4});
        int result = count(root);
        System.out.println(result);
    }
}
