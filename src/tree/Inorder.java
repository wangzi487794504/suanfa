package tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * ClassName:Inorder
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/7/13 15:52
 * @Version 1.0
 */
public class Inorder {
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        //定义一个数组
        ArrayList<Integer> objects = new ArrayList<>();
        //定义一个栈
        Stack stack=new Stack();
        TreeNode temp=root;
        while (!stack.empty()|| temp!=null){
            if (temp!=null){
                stack.push(temp);
                temp=temp.left;
            }
            else {
                temp = (TreeNode) stack.pop();
                objects.add(temp.val);
                temp=temp.right;
            }
        }
        return  objects;
    }

    public static void main(String[] args) {
        TreeNode right=new TreeNode(3);
        TreeNode left2=new TreeNode(4);
        TreeNode left=new TreeNode(2,left2,right);
        TreeNode root=new TreeNode(1,left,null);
        ArrayList<Integer> integers = preorderTraversal(root);
        integers.forEach((Integer temp)->{
            System.out.println(temp);
        });
    }
}
