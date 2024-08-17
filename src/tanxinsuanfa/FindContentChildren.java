package tanxinsuanfa;

import java.util.Arrays;

/**
 * ClassName:FindContentChildren
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/7/18 15:11
 * @Version 1.0
 */
public class FindContentChildren {
    public static int findContentChildren(int[] g, int[] s) {
        //首先是排序,g是胃口,s是饼干
        Arrays.sort(g);
        Arrays.sort(s);
        int index=s.length-1;
        int result=0;
        for (int i = s.length-1; i >=0; i--) {
            System.out.println("i="+i);
//            System.out.println("i="+i);
            while (index>=0 && s[index]>=g[i]){
                result++;
                index--;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1, 2,3}, new int[]{1, 1}));
    }
}
