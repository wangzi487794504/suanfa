package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ClassName:NLevelOrder
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/8 11:28
 * @Version 1.0
 */
public class NLevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        //定义一个队列
        Queue<Node> queue=new LinkedBlockingQueue();
        //定义一个数组
        List<List<Integer>> integers=new ArrayList<>();
        if (root!=null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            int size=queue.size();
            ArrayList<Integer> list=new ArrayList<>();
            while (size!=0){
                size=size-1;
                Node temp = queue.poll();
                list.add(temp.val);
                if (temp.children!=null){
                    temp.children.forEach(node->{
                        if (node!=null){
                            queue.add(node);
                        }
                    });
                }
            }
            integers.add(list);
        }
        return integers;
    }
}
