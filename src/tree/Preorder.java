package tree;


import java.util.ArrayList;
import java.util.Stack;

/**
 * ClassName:Preorder
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/7/13 12:37
 * @Version 1.0
 */
public class Preorder {
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        //定义一个数组
        ArrayList<Integer> objects = new ArrayList<>();
        //定义一个栈
        Stack stack=new Stack();
        stack.push(root);
        while (!stack.empty()){
            TreeNode temp= (TreeNode) stack.pop();
            if (temp==null){
            }
            else {
                objects.add(temp.val);
                if (temp.right!=null){
                    stack.push(temp.right);
                }
                if (temp.left!=null){
                    stack.push(temp.left);
                }
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



