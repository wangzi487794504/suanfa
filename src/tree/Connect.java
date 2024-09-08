package tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * ClassName:Connect
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/8 14:57
 * @Version 1.0
 */
public class Connect {


    public Node connect(Node root) {
        if (root==null){
            return root;
        }
        //层序遍历
        Queue<Node> queue=new ArrayDeque<>();
        queue.add(root);
        while (queue.isEmpty()==false){
            int size= queue.size();
            while (size>0){
                size--;
                Node temp = queue.poll();
                if (size==0){
                    temp.next=null;
                }
                else {
                    temp.next=queue.peek();
                }
                if (temp.left!=null){
                    queue.add(temp.left);
                }
                if (temp.right!=null){
                    queue.add(temp.right);
                }
            }
        }
        return root;
    }
    class   Node{
       int val;
       Node left;
       Node right;
       Node next;

        Node() {}

        Node(int _val) {
                val = _val;
            }

        Node(int _val, Node _left, Node _right, Node _next) {
                val = _val;
                left = _left;
                right = _right;
                next = _next;
            }
        }
}
