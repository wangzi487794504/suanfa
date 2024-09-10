package tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * ClassName:FindBottomLeftValue
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/8 21:31
 * @Version 1.0
 */
public class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        //使用层序遍历记录最后一个层的第一个，
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        int result=Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            int size= queue.size();
            result=Integer.MIN_VALUE;
            boolean flag=true;
            while (size>0){
                size--;
                TreeNode temp = queue.poll();
                if (temp.left==null && temp.right==null && flag){
                    result= temp.val;
                    flag=false;
                }
                if (temp.left!=null){
                    queue.add(temp.left);
                }
                if (temp.right!=null){
                    queue.add(temp.right);
                }
            }

        }
        return result;
    }
}
