package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName:BinaryTreePaths
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/8 19:46
 * @Version 1.0
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if (root==null){
            return list;
        }
        String s="";
        stack.push(root);
        while (stack.isEmpty()==false){
            TreeNode temp = stack.pop();
            if (stack.isEmpty() && s.length()>1){
                System.out.println("aa");
                s.substring(3);
            }
            s+=temp.val;
            if (temp.right!=null){
                stack.push(temp.right);
            }
            if (temp.left!=null){
                stack.push(temp.left);
            }
            if (temp.left==null && temp.right==null){
                list.add(s);
                s.substring(s.length()-1);
                continue;
            }
            s+="->";
        }
        return list;
    }
    public List<String> binaryTreePaths2(TreeNode root) {
        StringBuilder builder=new StringBuilder();
        List<String> list=new ArrayList<>();
        backtracking(builder, root, list);
        return list;
    }
    void backtracking(StringBuilder builder,TreeNode node,List<String> list){
        builder.append(node.val);
        StringBuilder temp=new StringBuilder(builder);
        //回溯结束条件
        if (node.left==null && node.right==null){
            list.add(builder.toString());
            return;
        }
        if (node.left!=null){
            builder.append("->");
            backtracking(builder, node.left,list);
        }
        System.out.println(builder==temp);
        //回溯
        builder=temp;
        if (node.right!=null){
            builder.append("->");
            backtracking(builder, node.right,list);
        }
    }
}
