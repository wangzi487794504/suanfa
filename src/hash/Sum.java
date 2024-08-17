package hash;

import java.util.HashMap;

/**
 * ClassName:Sum
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/10 17:59
 * @Version 1.0
 */
public class Sum {
    private HashMap<Integer,Integer> hashMap=new HashMap<>();
    public  int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        for (int i=0;i<nums.length;i++) {
            if (hashMap.containsKey(target-nums[i])){
                result[0]=hashMap.get(target-nums[i]);
                result[1]=i;
                return result;
            }
            else {
                hashMap.put(nums[i],i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{2,7,11,15};
        int[] ints = new Sum().twoSum(nums, 9);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
