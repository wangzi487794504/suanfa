package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * ClassName:Postorder
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/8 16:20
 * @Version 1.0
 */
public class Postorder {
    public List<Integer> postorder(Node root) {
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
                temp.children.forEach(node -> {
                    stack.push(node);
                });
            }
        }
        Collections.reverse(list);
        return list;
    }
}
