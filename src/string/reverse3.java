package string;

import java.util.Arrays;

/**
 * ClassName:reverse3
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/7/3 14:12
 * @Version 1.0
 */
public class reverse3 {
    public static String reverseWords(String s) {
        char[] charArray = s.toCharArray();

        //定义快慢指针，去除空格
        int slow=0;
        for (int fast = 0; fast < charArray.length; fast++) {
            if (charArray[fast]!=' '){
                if (slow!=0)
                {
                    charArray[slow++]=' ';
                }
                while (fast<charArray.length && charArray[fast]!=' '){
                    charArray[slow] = charArray[fast];
                    fast++;
                    slow++;
                }
            }
        }
        System.out.println(slow);
        //进行所有字符串翻转，别忘了截断
        charArray = Arrays.copyOf(charArray, slow);

        System.out.println("****翻转之前的***");
        System.out.println(String.valueOf(charArray));
        reverseString(charArray);
        System.out.println("****翻转之后的字符串*****");
        System.out.println(charArray);
        //进行单词翻转,仍然是两个指针一起走
        slow=0;
        for (int i=0;i<charArray.length;i++){
            if (i==charArray.length-1){
                reverseString(charArray,slow,i);
                System.out.println("ii="+i);
            }
            else if (charArray[i]==' '){
                System.out.println("slow="+slow);
                System.out.println("iii="+i);
                reverseString(charArray,slow,i-1);
                slow=i+1;
            }
        }
        return String.valueOf(charArray);
    }

    public static void reverseString(char s[],int index,int end) {
        //使用双向链表
        //定义两个指针
        int epoch=(end-index+1)/2;
        for (int i=0;i<epoch;i++){
//            System.out.println(i);
//            System.out.println((end-index+1)/2);
            char temp=s[index];
            s[index++]=s[end];
            s[end--]=temp;
        }
    }
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
        String s="  hello world  ";
        System.out.println(reverseWords(s));
    }
}
