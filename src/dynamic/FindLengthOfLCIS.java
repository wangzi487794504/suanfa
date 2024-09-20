package dynamic;

/**
 * ClassName:FindLengthOfLCIS
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/18 20:47
 * @Version 1.0
 */
public class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        //双指针
        int left=0;
        int result=1;
        for (int i = 1; i < nums.length; i++) {
            int temp=0;
            if (nums[i]>nums[left]){

                temp++;
                left++;
                System.out.println(temp);
            }
            else {
                temp=1;
                left=i;
            }
            result=result>temp ? result:temp;
        }
        return result;
    }
}
