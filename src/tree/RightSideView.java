package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName:RightSideView
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/8 10:32
 * @Version 1.0
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        //思路：如果左右子树都有，只让他存右子树即可
        //如果只有左子树，则存放左子树
        List<Integer> lists=new ArrayList<>();
        Queue<TreeNode> queue=new ArrayDeque<>();
        if (root==null){
            return lists;
        }
        queue.add(root);
        while (queue.isEmpty()==false){
            TreeNode temp = queue.poll();
            lists.add(temp.val);
            if (temp.right!=null){
                System.out.println("aa");
                queue.add(temp.right);
            }
            else if (temp.left!=null){
                queue.add(temp.left);
            }
            else {

            }
        }
        return lists;
    }
    public List<Integer> rightSideView2(TreeNode root) {
        //思路：从右到左一次没有，一层只能有一个
        List<Integer> lists=new ArrayList<>();
        Queue<TreeNode> queue=new ArrayDeque<>();
        if (root==null){
            return lists;
        }
        queue.add(root);
        boolean flag=false;
        while (queue.isEmpty()==false){
            int size= queue.size();
            flag=false;
            while (size>0){
                size--;
                TreeNode temp = queue.poll();
                if (temp!=null && flag==false){
                    lists.add(temp.val);
                    flag=true;
                }
                if (temp.right!=null){
                    queue.add(temp.right);
                }
                if (temp.left!=null){
                    queue.add(temp.left);
                }

            }
        }
        return lists;
    }
}
