package string;

/**
 * ClassName:reverse
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/7/2 13:15
 * @Version 1.0
 */
public class Reverse {
    public static void reverseString(char[] s) {
        //使用双向链表
        //定义两个指针
        int index=0;
        int end=s.length-1;
        for (int i=0;i<s.length/2;i++){
            char temp=s[index];
            s[index++]=s[end];
            s[end--]=temp;
        }
    }

    public static void main(String[] args) {
        char[] s=new char[]{'a','b','c','d','e'};
        reverseString(s);
        System.out.println(s);
    }

}
