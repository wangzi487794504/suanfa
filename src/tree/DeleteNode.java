package tree;

import jdk.nashorn.internal.ir.IfNode;

/**
 * ClassName:DeleteNode
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/10 21:53
 * @Version 1.0
 */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        //有五种情况
        if (root==null){
            return null;
        }
        if (root.val==key){
            // 一是叶子节点被移除，此时对于其他所有节点都没有影响
            if (root.left==null && root.right==null){
                //把这个节点置null
                return null;
            }
            //二是不是叶子节点，但是只有一个左孩子，左子树替代它
            else if (root.left!=null && root.right==null){
                //把它父节点的左执向他的左
                return root.left;
            }
            //三是只要一个有孩子，右子树的左子树替代他
            else if (root.right!=null && root.left==null) {
                return  root.right;
            }
            //四是左右孩子都有
            else {
                //要么移动左孩子的最右边，要么以移动右孩子的最左边
                //左孩子的最右面
                TreeNode temp=root.left;
                //找到左孩子最右面的节点
                while (temp.right!=null){
                    temp=temp.right;
                }
                //替代root节点
                temp.right=root.right;
                root=root.left;
                return root;
            }
        }
        //五是找不到
        if (root.val>key){
            root.left=deleteNode(root.left, key);
        }
        if (root.val<key){
            root.right=deleteNode(root.right, key);
        }
        return root;
    }
}
