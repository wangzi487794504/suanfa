package hash;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName:FourSum2
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/11 14:50
 * @Version 1.0
 */
public class FourSum2 {
    private List<List<Integer>> listList=new LinkedList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //排序
        Arrays.sort(nums);
        //需要再套一层
        for (int k = 0; k < nums.length; k++) {
            if (nums[k]>target && nums[k]>0){
                return listList;
            }
            if (k>0 && nums[k]==nums[k-1]){
                continue;
            }
            for (int i = k+1; i < nums.length; i++) {
                int left = i + 1;
                int right = nums.length - 1;
                //target大于目标值了，target>0，说明和不是负数
                if (nums[k]+nums[i]>target && target>0 ){
                    break;
                }
                if (i>k+1 && nums[i]==nums[i-1]){
                    continue;
                }
                while (left<right){
                    if (nums[k]+nums[i]+nums[left]+nums[right]>target){
                        right--;
                    }
                    else if (nums[k]+nums[i]+nums[left]+nums[right]<target) {
                        left++;
                    }
                    else {
                        LinkedList<Integer> list = new LinkedList<>();
                        list.add(nums[k]);
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
        }
        return listList;
    }
    public static void main(String[] args) {
        int[] nums=new int[]{1,-2,-5,-4,-3,3,3,5};
//        int[] nums=new int[]{1,0,-1,0,-2,2};
        List<List<Integer>> lists = new FourSum2().fourSum(nums, -11);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
