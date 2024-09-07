package tanxinsuanfa;

/**
 * ClassName:Jump
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/22 21:01
 * @Version 1.0
 */
public class Jump {
    public int jump(int[] nums) {
        //todo 找能最远到终点的那个
        int target=nums.length-1;
        int temp=0;
        for (int i = 0; i < target; i++) {
            System.out.println("iii="+i);
            if (nums[i]>=target-i){
                System.out.println("="+i);
                target=i;
                System.out.println("target="+target);
                i=0;
                temp++;
            }
        }
        if (target==0){
            return temp;
        }
        return 0;
    }
    public int jump2(int[] nums) {
        int jumps = 0; // 初始化跳跃次数
        int currentEnd = 0; // 当前段的结束位置
        int furthest = 0; // 最远可以达到的位置

        for (int i = 0; i < nums.length - 1; i++) {
            furthest = Math.max(furthest, i + nums[i]); // 更新最远达到的距离
            if (i == currentEnd) { // 当到达当前段的结束位置
                jumps++; // 需要跳跃一次
                currentEnd = furthest; // 更新段的结束位置
            }
        }
        return jumps; // 返回跳跃次数
    }

    public static void main(String[] args) {
        System.out.println(new Jump().jump(new int[]{2,3,1,1,4}));
    }
}
