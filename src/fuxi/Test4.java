package fuxi;

import tree.TreeNode;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * ClassName:Test4
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/10/4 21:25
 * @Version 1.0
 */
public class Test4 {
//    List<List<Integer>> lists=new ArrayList<>();
    public List<Integer> rob(TreeNode root) {
        List<Integer> list=new ArrayList<>();
       if (root==null){
           return list;
       }
        Queue<TreeNode> stack=new ArrayDeque<>();
        stack.add(root);
        while (stack.isEmpty()==false){
            int size=stack.size();
            while (size-->0){
                TreeNode temp=stack.poll();
                if (size==0){
                    list.add(temp.val);
                }
                if (temp.left!=null){
                    stack.add(temp.left);
                }
                if (temp.right!=null){
                    stack.add(temp.right);
                }
            }
//            lists.add(list);
        }
        return list;
    }
}
