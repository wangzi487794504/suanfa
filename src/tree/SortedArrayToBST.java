package tree;

import java.util.Arrays;

/**
 * ClassName:SortedArrayToBST
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/11 10:22
 * @Version 1.0
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        //先序分区间，使用的是闭区间，这里没问题
        return backingTracking(nums, 0, nums.length-1);
    }
    TreeNode backingTracking(int[] nums,int left,int right){
        //闭区间左右相等时应该取值，这里也没问题
        if (left>right){
            return null;
        }
        //这里有问题，left=index的时候有问题，必须要让左子树最后一个元素索引为0
        int index=left+((right-left)>>1);
        TreeNode root=new TreeNode(nums[index]);
        //遍历左
        //这样写，用的还是nums的长度
//        root.left=backingTracking(Arrays.copyOfRange(nums, 0, index), 0, index-1);
        root.left=backingTracking(nums, left, index-1);
        //遍历右边
        root.right=backingTracking(nums, index+1, right);
        return root;
    }
}
