package tree;


import java.util.*;
import java.util.stream.Collectors;

/**
 * ClassName:LevelOrderBottom
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/8 10:16
 * @Version 1.0
 */
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //层序遍历，集合翻转
        List<List<Integer>> lists=new ArrayList<>();
        //定义一个队列，先进先出
        Queue<TreeNode> queue=new ArrayDeque<>();
        if (root==null){
            return lists;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            //怎么保留每一层，用queue。size就可以确定
            //因为queue的每一层都在队列中
            int size=queue.size();
            List<Integer> list=new ArrayList<>();
            while (size>0){
                size--;
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left!=null){
                    queue.add(temp.left);
                }
                if (temp.right!=null){
                    queue.add(temp.right);
                }
            }
            lists.add(list);
        }
        //进行顺序反转
        Collections.reverse(lists);
        return lists;
    }
}
