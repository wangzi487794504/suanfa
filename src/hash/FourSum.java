package hash;

import java.util.HashMap;

/**
 * ClassName:FourSum
 * Package:
 * Description:就是说在执行方法的时候，局部变量会保存在栈中，方法结束局部变量也会出栈，
 * 随后会被垃圾回收掉，而此时，内部类对象可能还存在，如果内部类对象这时直接去访问局部变量的话就会出问题，
 * 因为外部局部变量已经被回收了，解决办法就是把匿名内部类要访问的局部变量复制一份作为内部类对象的成员变量，查阅资料或者通过反编译工具对代码进行反编译会发现，底层确实定义了一个新的变量，通过内部类构造函数将外部变量复制给内部类变量。
 *
 * 为何还需要用final修饰？
 * 其实复制变量的方式会造成一个数据不一致的问题，在执行方法的时候局部变量的值改变了却无法通知匿名内部类的变量，随着程序的运行，
 * 就会导致程序运行的结果与预期不同，于是使用final修饰这个变量，使它成为一个常量，这样就保证了数据的一致性。
 *
 * @Aurhor 王子杰
 * @Create 2024/8/10 18:56
 * @Version 1.0
 */
public class FourSum {
    private HashMap<Integer,Integer> hashMapFirst=new HashMap<>();
    private HashMap<Integer,Integer> hashMapSecond=new HashMap<>();
    private int count=0;
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result=0;
        int result2=0;
        for (int i=0;i<nums1.length;i++) {
            for (int j = 0; j < nums2.length; j++) {
                result = nums1[i] + nums2[j];
                result2 = nums3[i] + nums4[j];
                if (hashMapFirst.containsKey(result)) {
                    hashMapFirst.put(result, hashMapFirst.get(result) + 1);
                } else {
                    hashMapFirst.put(result, 1);
                }
                if (hashMapSecond.containsKey(result2)) {
                    hashMapSecond.put(result2, hashMapSecond.get(result2) + 1);
                } else {
                    hashMapSecond.put(result2, 1);
                }
            }
        }
        hashMapFirst.forEach((k, v) -> {
            if (hashMapSecond.containsKey(0 - k)) {
                //注意：总数要是first的v乘以second的v   -1  3   1   2
                count = count + v*hashMapSecond.get(0-k);
            }
        });
        return count;
    }
}
