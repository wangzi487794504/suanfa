package tree;

import test.A;

import java.util.Arrays;

/**
 * ClassName:ConstructMaximumBinaryTree
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/10 9:26
 * @Version 1.0
 */
public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return backtracking(nums);
    }
    TreeNode backtracking(int[] nums){
        int temp=Integer.MIN_VALUE;
        int index=0;
        //结束判断
        if (nums.length==0){
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>temp){
                index=i;
                System.out.println(nums[i]);
                temp=nums[i];
            }
        }
        TreeNode root=new TreeNode(temp);
        //todo 截取数组
        int[] leftTree= Arrays.copyOfRange(nums, 0, index);
        int[] rightTree= Arrays.copyOfRange(nums, index+1, nums.length);
        //递归
        root.left=backtracking(leftTree);
        root.right=backtracking(rightTree);
        return root;
    }
}
