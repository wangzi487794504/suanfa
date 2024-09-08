package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName:LargestValues
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/8 11:40
 * @Version 1.0
 */
public class LargestValues {
    public List<Integer> largestValues(TreeNode root) {
        //思路：从右到左一次没有，一层只能有一个
        List<Integer> lists=new ArrayList<>();
        Queue<TreeNode> queue=new ArrayDeque<>();
        if (root==null){
            return lists;
        }
        queue.add(root);
        while (queue.isEmpty()==false){
            int size= queue.size();
            int value=Integer.MIN_VALUE;
            while (size>0){
                size--;
                TreeNode temp = queue.poll();
                if (value<temp.val){
                    value= temp.val;
                }
                if (temp.left!=null){
                    queue.add(temp.left);
                }
                if (temp.right!=null){
                    queue.add(temp.right);
                }
            }
            lists.add(value);
        }
        return lists;
    }
}
