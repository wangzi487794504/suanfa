package sort;

/**
 * ClassName:HalfInsertSort
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/15 16:00
 * @Version 1.0
 */
public class HalfInsertSort {
    static void sort(int[] nums){
        //就是在原本直接插入的基础上使用了二分查找技术
        int j;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]<nums[i-1]){
                //在这里使用二分法，因为局部有序
                //左闭右开
                int temp=nums[i];
                int left=0;
                int right=i;
                int mid=(left+right)/2;
                //是开区间，所以不能相等
                while (left<right){
                    mid=(left+right)/2;
                    if (nums[mid]>temp){
                        right=mid;
                    }
                    //如果 nums[mid] <= temp，说明 temp 可以插入在 mid 之后，因此将 left 设置为 mid + 1。
                    else{
                        //闭区间
                        left=mid+1;
                    }
                }
                for (j=i-1;j>=left;j--){
                    nums[j+1]=nums[j];
                }
                nums[j+1]=temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums=new int[]{49,38,65,97,76,13,27,49,55,4};
        sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
