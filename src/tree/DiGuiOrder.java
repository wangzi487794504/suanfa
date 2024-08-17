package tree;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;

/**
 * ClassName:DiGuiOrder
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/7/15 23:08
 * @Version 1.0
 */
public class DiGuiOrder {
    private static ArrayList<Integer> list = new ArrayList<>();
    public static void preorder(TreeNode root,ArrayList list){
        //先序，先遍历根节点
        if (root==null){
            return ;
        }
        list.add(root.val);
        TreeNode temp=new TreeNode();
        temp=root.right;
        root.right=root.left;
        root.left=temp;
        preorder(root.left,list);
        preorder(root.right,list);
    }

    public static void main(String[] args) {
        TreeNode right=new TreeNode(3);
        TreeNode left2=new TreeNode(4);
        TreeNode left=new TreeNode(2,left2,right);
        TreeNode root=new TreeNode(1,left,null);
        preorder(root,list);
        list.forEach((Integer temp)->{
            System.out.println(temp);
        });
    }

}
