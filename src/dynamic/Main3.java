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
public class Main3 {
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
            if (isOrder(nums1) || isOrder(nums2)){
                System.out.println("YES");
                continue;
            }
            boolean flag=false;
            for (int i = 0; i < N; i++) {
                int temp=nums1[i];
                nums1[i]=nums2[i];
                nums2[i]=temp;
                if (isOrder(nums1) || isOrder(nums2)){
                    flag=true;
                    break;
                }
                temp=nums1[i];
                nums1[i]=nums2[i];
                nums2[i]=temp;
            }
            System.out.println(flag? "YES":"NO");
        }
        scanner.close();
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
        }
        return flagD || flagA;
    }
}
