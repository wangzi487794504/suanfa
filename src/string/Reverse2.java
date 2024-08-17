package string;

/**
 * ClassName:Reverse2
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/7/2 13:25
 * @Version 1.0
 */
public class Reverse2 {
    public static String reverseStr(String s, int k) {
        char[] str=s.toCharArray();
        System.out.println(str);
        //翻转2k的字符串，所以把2k当做子串
        for (int i=0;i<str.length;i=i+k*2){
            System.out.println("aa");
            //剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
            //判断剩余长度，少于k个,则将剩余字符全部反转
            if ((str.length-i)<= k){
                System.out.println(i);
                System.out.println("-------");
                System.out.println(s.length()-1);
                reverseString(str,i,s.length()-1);
            }
            else {
                System.out.println("******");
                System.out.println(i);
                //0-1
                reverseString(str,i,i+k-1);
            }

        }
        return String.valueOf(str);
    }
    public static void reverseString(char s[],int index,int end) {
        //使用双向链表
        //定义两个指针
        int epoch=(end-index+1)/2;
        for (int i=0;i<epoch;i++){
            System.out.println(i);
            System.out.println((end-index+1)/2);
            char temp=s[index];
            s[index++]=s[end];
            s[end--]=temp;
        }
    }

    public static void main(String[] args) {
        String s="abcd";
        System.out.println(reverseStr(s, 4));
    }
}
