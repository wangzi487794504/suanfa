package tanxinsuanfa;

import java.util.Arrays;

/**
 * ClassName:LargestSumAfterKNegations
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/22 22:07
 * @Version 1.0
 */
public class LargestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        //先排序
        Arrays.sort(nums);
        //如果都是正说了找绝对值最接近0的那个给他
        int absMinValue=Integer.MAX_VALUE;
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<0 && k>0){
                nums[i]=-nums[i];
                k--;
                if (Math.abs(nums[i])<absMinValue){
                    absMinValue=Math.abs(nums[i]);
                }
            }
            else {
               if (Math.abs(nums[i])<absMinValue){
                   absMinValue=Math.abs(nums[i]);
               }
            }
            sum+=nums[i];
        }
        //k不剩或者k声偶数
        if (k==0 || k%2==0){
            return sum;
        }
        else {
            //上面加了一次他了，因为for循环么一次都加他了
            return sum-2*absMinValue;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LargestSumAfterKNegations().largestSumAfterKNegations(new int[]{2,-3,-1,5,-4}, 2));
    }
}
