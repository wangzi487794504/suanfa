package dynamic;

import java.util.Scanner;

/**
 * ClassName:Main
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/19 15:54
 * @Version 1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //数据组数
        int T = scanner.nextInt();
        while (T-->0){
            //数组长度
            int N = scanner.nextInt();
            int[] nums1=new int[N];
            int[] nums2=new int[N];
            for (int i = 0; i < nums1.length; i++) {
                nums1[i]= scanner.nextInt();
            }
            for (int i = 0; i < nums2.length; i++) {
                nums2[i]= scanner.nextInt();
            }
            System.out.println(sort(nums1, nums2)? "YES":"NO");
        }
        scanner.close();
    }
    public static boolean sort(int[] nums1,int[] nums2){
        int[] min=new int[nums1.length];
        int[] max=new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            min[i]=Math.min(nums1[i],nums2[i]);
            max[i]=Math.max(nums1[i],nums2[i]);
        }
        //验证是不是升序
        return isOrder(min) || isOrder(max);
    }
    private static boolean isOrder(int[] temp){
        boolean flagD=true;
        boolean flagA=true;
        for (int i = 1; i < temp.length; i++) {
            if (temp[i]<temp[i-1]){
                flagA=false;
            }
            if (temp[i]>temp[i-1]){
                flagD=false;
            }
            if (!flagD && !flagA){
                return false;
            }
        }
        return true;
    }
}
