package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * ClassName:Preorder2
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/8 15:57
 * @Version 1.0
 */
public class Preorder2 {
    public List<Integer> preorder(Node root) {
        List<Integer> list=new ArrayList<>();
        Stack<Node> stack=new Stack<>();
        //递归
        if (root==null){
            return list;
        }
        stack.push(root);
        while (stack.isEmpty()==false){
            Node temp = stack.pop();
            list.add(temp.val);
            if (temp.children!=null) {
                Collections.reverse(temp.children);
                temp.children.forEach(node -> {
                    stack.push(node);
                });
            }
        }
        return list;
    }
}
