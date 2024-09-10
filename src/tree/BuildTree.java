package tree;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * ClassName:BuildTree
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/9 10:04
 * @Version 1.0
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //TODO 前序遍历的第一个是头结点
        //拿到头结点
        if (preorder.length==0){
            return null;
        }
        int value=preorder[0];
        //使用头结点分割中序遍历，此时左边是左子树，右边是右子树
        int index=0;
        for (; index < inorder.length; index++) {
            if (inorder[index]==value){
                break;
            }
        }
        TreeNode root=new TreeNode(value);
        //此时已经找到左子树和右子树的分割点
        //分割左子树和右子树
        int[] leftTree= Arrays.copyOfRange(inorder, 0, index);
        int[] rightTree=Arrays.copyOfRange(inorder, index+1, inorder.length);
        for (int i = 0; i < rightTree.length; i++) {
            System.out.println(rightTree[i]);
        }
        //分割后序序列，后序是左右根，怎么确定左的长度是关键
        //左子树的长度都是相等的，所以左子树的长度就是index
        // System.out.println(inorder[index]);
        int[] postLeftTree=Arrays.copyOfRange(preorder, 1, index+1);

        System.out.println("index");
        int[] postRightTree=Arrays.copyOfRange(preorder, index+1, inorder.length);
        root.left=buildTree(postLeftTree,leftTree);
        root.right=buildTree(postRightTree,rightTree);
        return root;
    }

    public static void main(String[] args) {
        AtomicStampedReference atomicStampedReference=new AtomicStampedReference(0, 0);
        AtomicInteger atomicInteger=new AtomicInteger(0);
        atomicInteger.compareAndSet(0, 100);

    }
}
