package sort;

/**
 * ClassName:Test
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/10/16 9:23
 * @Version 1.0
 */
public class DuiFu {
    //堆排序
    //做一个insert，从低向上插入
    public void insert(int[] nums,int index){
        //给你数组和位置表示树的层序遍历
        //去找父节点，等于0的时候是根节点
        int temp=(index-1)/2;
        while (temp >=0){
            //比较他和父节点的大小，小于就交换
            if(nums[index]< nums[temp] ){
                //交换
                int val=nums[temp];
                nums[temp]=nums[index];
                nums[index]=val;
            }
            temp=(index-1)/2;
        }
    }

    public static void main(String[] args) {
        DuiFu test = new DuiFu();
        int[] nums=new int[]{49,38,65,97,76,13,27,49,55,4};
        for (int i = 0; i < nums.length; i++) {
            test.insert(nums, i);
        }
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
