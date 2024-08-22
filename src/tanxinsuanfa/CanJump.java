package tanxinsuanfa;

/**
 * ClassName:CanJump
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/22 20:45
 * @Version 1.0
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        //todo 判断从右到左有谁能到达最后一个，如果有一个到，就去找谁能到他
        int target=nums.length-1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i]>= target-i){
                target=i;
            }
        }
        if (target==0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new CanJump().canJump(new int[]{2,3,1,1,4}));
    }
}
