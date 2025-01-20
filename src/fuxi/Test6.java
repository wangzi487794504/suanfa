package fuxi;

/**
 * ClassName:Test6
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/10/8 9:31
 * @Version 1.0
 */
public class Test6 {
    //交换算法
    void swap(int[] nums,int positionA,int positionB){
        int temp=nums[positionA];
        nums[positionA]=nums[positionB];
        nums[positionB]=temp;
    }
    //todo heapfy算法 ,拿出头元素，然后修正
    void heapFy(int[] nums,int size,int index){
        //比较第一个元素和左子节点的大小
        int left=index*2+1;
        while (left<size){
            //看看右节点有没有超过size的大小，如果没有，就选两个节点中最大值
            int largest= (left+1)<size && nums[left]<nums[left+1] ? (left+1): left ;
            //比较最大的子节点和index谁大
            largest=nums[largest]>nums[index] ? largest:index;
            //如果最大值还是index，就不用操作了
            if (largest==index){
                break;
            }
            swap(nums, index, largest);
            index=largest;
            left=index*2+1;
        }
    }
    //todo heapinsert算法，已经算出最大或者最小的那个了
    void heapInsert(int[] nums,int index){
        while (nums[index]>nums[(index-1)/2]){
            swap(nums, index, (index-1)/2);
            index=(index-1)/2;
        }
    }
    void heapSort(int[] nums){
        //这样插入复杂度是onlogn
        for (int i = 0; i < nums.length; i++) {
            heapInsert(nums, i);
        }
        //这样插入是on
//        for (int i = nums.length-1; i >= 0; i--) {
//            heapInsert(nums, i);
//        }
        //交换第一个和最后一个，并把长度减1
        int size= nums.length-1;
        while (size>0){
            swap(nums,0,size );
            heapFy(nums, size,0);
            size--;
        }
        for (int num : nums) {
            System.out.println(num);
        }
    }
    public static void main(String[] args) {
        new Test6().heapSort(new int[]{49,38,65,97,76,13,27,49,55,4});
    }
}
