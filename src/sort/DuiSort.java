package sort;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * ClassName:DuiSort
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/16 15:42
 * @Version 1.0
 */
public class DuiSort {
    //如果移除一个元素
    static void heapfy(int[] nums,int index,int heapSize){
        //先交换两个元素
        int left=index*2+1;
        while (left<heapSize){
            int largest= (left+1)<heapSize &&( nums[left+1]>nums[left]) ? (left+1): left;
            largest=nums[index]> nums[largest]? index:largest;
            if (largest==index){
               break;
            }
            swap(nums, index, largest);
            index=largest;
            left=index*2+1;
        }
    }
    //新加进来的说，一直与它父节点比较大小，大则交换，一直到比不过或为
    private static void heapInsert(int[] nums,int index){
        while (nums[index]>nums[(index-1)/2]){
            swap(nums, index, (index-1)/2);
            index=(index-1)/2;
        }
    }
    static void swap(int[] nums,int positionA,int positionB){
        int temp=nums[positionA];
        nums[positionA] = nums[positionB];
        nums[positionB]=temp;
    }
    static void heapSort(int[] nums){
        if (nums==null || nums.length<2){
            return;
        }
        //使用元素插入
//        for (int i = 0; i < nums.length; i++) {
//            heapInsert(nums, i);
//        }
        //如果直接给数组，从下网上建立大根堆
        for (int i = nums.length/2-1; i>=0; i--) {
            heapfy(nums, i,nums.length);
        }
        int heapSize= nums.length-1;
        //取出第一个，然后修正;
        while (heapSize>0){
            swap(nums, 0, heapSize);
            heapfy(nums, 0,heapSize);
            heapSize--;
        }
        for (int num : nums) {
            System.out.println(num);
        }
    }
    public static void main(String[] args) {
        int[] nums=new int[]{49,38,65,97,76,13,27,49,55,4};
        heapSort(nums);

    }
    volatile int a;
}
