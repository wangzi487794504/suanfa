package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName:AverageOfLevels
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/8 11:13
 * @Version 1.0
 */
public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue=new ArrayDeque<>();
        List<Double> list=new ArrayList<>();
        queue.add(root);
        while (queue.isEmpty()==false){
            int size= queue.size();
            int laySize= queue.size();
            Double layerSum=0.0;
            while (size>0){
                size--;
                TreeNode temp = queue.poll();
                layerSum+=temp.val;
                if (temp.left!=null){
                    queue.add(temp.left);
                }
                if (temp.right!=null){
                    queue.add(temp.right);
                }
            }
            list.add(layerSum/laySize);
        }
        return list;
    }
}
