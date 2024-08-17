package tree;

/**
 * ClassName:DeepTree
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/7/16 9:55
 * @Version 1.0
 */
public class DeepTree {
    public static int maxDepth(TreeNode root) {
        //思路，使用递归
        //确定终止条件
        if (root==null){
            return 0;
        }

        //循环体
        int leftheight=maxDepth(root.left);
        int rightheight=maxDepth(root.right);
        //结果：比较左子树和右子树哪一个节点比较深
        return 1+Integer.max(leftheight, rightheight);

    }
    public static int minDepth(TreeNode root) {
        //思路，使用递归
        //确定终止条件
        if (root==null){
            return 0;
        }
        //循环体
        int leftheight=minDepth(root.left);//空返回0
        int rightheight=minDepth(root.right);
        //只有单个节点不是叶子节点，需要判断，这里是陷阱
        if (root.left==null&&root.right!=null){
            return rightheight+1;
        }
        else if(root.right==null&&root.left!=null){
            return leftheight+1;
        }
        else {
            return 1+Integer.min(leftheight, rightheight);
        }

    }
    public static void main(String[] args) {
        CreateTree createTree = new CreateTree();
        TreeNode root = createTree.createTree(new Integer[]{1, 2, 2, 3, 4});
        int result = minDepth(root);
        System.out.println(result);
    }

}
