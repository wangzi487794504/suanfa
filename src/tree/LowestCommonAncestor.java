package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:lowestCommonAncestor
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/10 20:23
 * @Version 1.0
 */
public class LowestCommonAncestor {
    List<List<TreeNode>> lists=new ArrayList<>();
    List<TreeNode> list=new ArrayList<>();
    TreeNode result=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //回溯，找到满足条件的点，记录他的路径
        //对比两个路径，找到最近的祖宗节点
        backTracking(root, p, q);
        for (int i = 0; i < lists.get(0).size() && i<lists.get(1).size(); i++) {
            if (lists.get(0).get(i)==lists.get(1).get(i)){
                result= lists.get(0).get(i);
            }
        }
        return result;
    }
    void backTracking(TreeNode root,TreeNode p,TreeNode q){
        list.add(root);
        if (root==p || root==q){
            lists.add(new ArrayList<>(list));
        }
        List<TreeNode> temp=new ArrayList<>(list);
        if ( root.left!=null && root.val>p.val && root.val>q.val ){
            backTracking(root.left, p,q );
            list=temp;
            return;
        }
        if (root.right!=null && root.val<p.val && root.val<q.val){
            backTracking(root.right, p,q );
            list=temp;
            return;
        }
        if (root.left!=null){
            backTracking(root.left, p,q );
            list=temp;
        }
        if (root.right!=null){
            backTracking(root.right, p,q);
            list=temp;
        }
    }
}
