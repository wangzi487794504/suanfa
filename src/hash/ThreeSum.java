package hash;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName:ThreeSum
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/11 9:39
 * @Version 1.0
 */
public class ThreeSum {
    private List<List<Integer>> listList=new LinkedList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        //排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //如果最左边的都大于0了，三个数就一定是正数
            if (nums[i]>0){
                return listList;
            }
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left<right){
                if (nums[i]+nums[left]+nums[right]>0){
                    right--;
                }
                else if (nums[i]+nums[left]+nums[right]<0) {
                    left++;
                }
                else {
                    LinkedList<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    listList.add(list);
                    while ((left+1)<right && nums[left+1]==nums[left]){
                        left++;
                    }
                    while ((left+1)<right && nums[right-1]==nums[right]){
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return listList;
    }
}
