package string;

/**
 * ClassName:StrStr
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/5 10:55
 * @Version 1.0
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        char[] charArray = haystack.toCharArray();
        char[] charArray1 = needle.toCharArray();
        int[] next = searchNext(charArray1);
        for (int i = 0; i < next.length; i++) {
            System.out.print(next[i]);
        }
        System.out.println("\n");
        //剪枝处理
        if (charArray.length<charArray1.length){
            return -1;
        }
        int j=0;
        for (int i = 0; i < charArray.length; i++) {
            while (j>0 && charArray[i]!=charArray1[j]){
                //跳到上一个和他匹配的地方
                j = next[j - 1];
            }
            if (charArray[i]==charArray1[j]){
                j++;
            }
            if (j == charArray1.length ) {
                return (i - needle.length() + 1);
            }
        }
        return -1;
    }
    public int [] searchNext(char[] arrays){
        //初始化
        int j=0;
        int[] next=new int[arrays.length];
        System.out.println("aa");
        //首先初始化next数组,如果第一个都不匹配肯定从0开始
        next[0]=0;
        for ( int i = 1; i < next.length; i++) {
            while (j>0 && arrays[i]!=arrays[j]){
                //不相等，我这个和你不等，我要退到上一个j-1相等的地方，下一个元素再和你比较
                j=next[j-1];
            }
            if (arrays[i]==arrays[j]){
                //相等了，都加就行了，我不用回退到你那边了
                arrays[i]=arrays[j];
                j++;
            }
            next[i]=j;
        }
        return next;
    }

    public static void main(String[] args) {
        String s="aabaabaafa";
        String s2="aabaaf";
        System.out.println(new StrStr().strStr(s, s2));
    }
}
