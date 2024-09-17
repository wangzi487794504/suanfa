package dynamic;

import java.util.Arrays;

/**
 * ClassName:FindTargetSumWays
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/12 10:00
 * @Version 1.0
 */
public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        //还是分为两个序列left和right，left+right=nums.sum
        //left-right=target
        //left=(target+sum)/2
        if ((target+ Arrays.stream(nums).sum())%2!=0 ||(target+ Arrays.stream(nums).sum())<0){
            return 0;
        }
        int left=(target+ Arrays.stream(nums).sum())/2;
        int[] parket=new int[left+1];
        parket[0]=1;
        //parket[j]的含义是在容量为j装满有多少种方法
        for (int i = 0; i < nums.length; i++) {
            for (int j = parket.length - 1; j >= nums[i]; j--) {
                //增加一个重量为nums[i]在parget[j]中parket[j-nums[i]]
                //parget[j-nums]
                parket[j]=parket[j]+parket[j-nums[i]];
            }
        }
        return parket[left];
    }
}
