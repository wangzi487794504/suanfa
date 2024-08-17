package tree;


import java.util.ArrayList;
import java.util.*;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ClassName:LevelOrder
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/7/15 21:18
 * @Version 1.0
 */
public class LevelOrder {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        //定义一个队列
        Queue queue=new LinkedBlockingQueue();
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
                TreeNode poll = (TreeNode) queue.poll();
                list.add(poll.val);
                if (poll.left!=null){
                    queue.add(poll.left);
                }
                if (poll.right!=null){
                    queue.add(poll.right);
                }
            }
            integers.add(list);
        }
        return integers;
    }
    public static void main(String[] args) {
        TreeNode right=new TreeNode(3);
        TreeNode left2=new TreeNode(4);
        TreeNode left=new TreeNode(2,left2,right);
        TreeNode root=new TreeNode(1,left,null);
//         integers = levelOrder(root);
//        integers.forEach((Integer temp)->{
//            System.out.println(temp);
//        });
    }
}
