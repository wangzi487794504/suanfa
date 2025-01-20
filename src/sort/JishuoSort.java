package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/**
 * ClassName:JishuoSort
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/10/8 19:27
 * @Version 1.0
 */
public class JishuoSort {
    public static void sort(int[] nums){
        //只适用于正数，如果有负数就加上最小负数的相反数
        if (nums==null || nums.length<2){
            return;
        }
        sort(nums,0, nums.length-1,maxBits(nums));
    }
    //求整个数组的最大位数是多少
    public static int maxBits(int[] arr){
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max=Math.max(max, arr[i]);
        }
        int res=0;
        while (max!=0){
            max=max/10;
            res++;
        }
        return res;
    }
    //digit最大位数
    public static int sort(int[] arr,int l,int r,int digit){
        //每位上就0-9是个数字
        final int radix=10;
        int i=0,j=0;
        int[] help=new int[r-l+1];
        int max=Integer.MIN_VALUE;
        //有多少位出多少次
        for (int d = 0; d < digit; d++) {
            int[] count=new int[radix];
        }
        return 0;
    }
    static class My{
        private  static AtomicReference<My> atomicReference=new AtomicReference<>();
        private static My my;
        private My(){

        }
        public static My getInstance(){
            //一直循环请求
            for (;;){
                my=atomicReference.get();
                if (my!=null){
                    return my;
                }
                //为空
                my=new My();
                if (atomicReference.compareAndSet(null, my)){
                    return my;
                }
            }
        }
    }

}
