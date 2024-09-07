package shuzu;

/**
 * ClassName:SortedSquares
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/4 17:08
 * @Version 1.0
 */
public class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        //双指针
        int left;
        int right=nums.length-1;
        int result=nums.length-1;
        for (left = 0; left < right;) {
            if ((int) Math.pow(nums[left], 2)>(int) Math.pow(nums[right], 2)){
                //交换
                int temp= (int) Math.pow(nums[right], 2);
                nums[right]= nums[left];
                nums[left]=temp;
                right--;
            }
            else {
                nums[right]=(int) Math.pow(nums[right], 2);
                right--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(new SortedSquares().sortedSquares(new int[]{-4,-1,0,3,10}));
        System.out.println("Aa");
    }
}
