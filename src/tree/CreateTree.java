package tree;

import java.util.ArrayList;
import java.util.*;
/**
 * ClassName:CreateTree
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/7/16 9:14
 * @Version 1.0
 */
public class CreateTree {
    private  static List<TreeNode> list=new ArrayList<>();      //用一个集合来存放每一个Node
    public TreeNode createTree(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            TreeNode node = new TreeNode(array[i], null, null);    //创建结点，每一个结点的左结点和右结点为null
            list.add(node); // list中存着每一个结点
        }
        // 构建二叉树
        if (list.size() > 0) {
            for (int i = 0; i < array.length / 2 - 1; i++) {       // i表示的是根节点的索引，从0开始
                if (list.get(2 * i + 1) != null) {
                    // 左结点
                    list.get(i).left = list.get(2 * i + 1);
                }
                if (list.get(2 * i + 2) != null) {
                    // 右结点
                    list.get(i).right = list.get(2 * i + 2);
                }
            }
            // 判断最后一个根结点：因为最后一个根结点可能没有右结点，所以单独拿出来处理
            int lastIndex = array.length / 2 - 1;
            // 左结点
            list.get(lastIndex).left = list.get(lastIndex * 2 + 1);
            // 右结点，如果数组的长度为奇数才有右结点
            if (array.length % 2 == 1) {
                list.get(lastIndex).right = list.get(lastIndex * 2 + 2);
            }
        }
        return list.get(0);
    }
}
