package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName:findMode
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/10 15:07
 * @Version 1.0
 */
public class FindMode {
    TreeNode temp=null;
    int value=0;
    int maxValue=1;
    List<Integer> list=new ArrayList<>();
    public int[] findMode(TreeNode root) {
        backTracking(root);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    void backTracking(TreeNode root){
        //中序遍历
        //统计频率一样的次数
        if (root==null){
            return ;
        }
        //左遍历
        backTracking(root.left);
        if (temp==null){
            value=1;
        }
        else if (root.val== temp.val){
            value++;
        }
        else {
            value=1;
        }
        if (value==maxValue){
            list.add(root.val);
        }
        if (value>maxValue){
            list.clear();
            list.add(root.val);
            maxValue=value;
        }
        temp=root;
        //右边李
        backTracking(root.right);
    }

    public static void main(String[] args) {


    }
}
