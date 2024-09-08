package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * ClassName:PostorderTraversal
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/7 20:28
 * @Version 1.0
 */
public class PostorderTraversal {
    //后序遍历左右根
    public List<Integer> postorderTraversal(TreeNode root) {
        //递归
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> list=new ArrayList<>();
        if (root==null){
            return list;
        }
        stack.push(root);
        while (stack.isEmpty()==false){
            TreeNode temp = stack.pop();
            System.out.println(temp.val);
            list.add(temp.val);
            //左
            if (temp.left!=null){
                stack.push(temp.left);
            }
            if (temp.right!=null){
                stack.push(temp.right);
            }
        }
        Collections.reverse(list);
        return list;
    }
}
