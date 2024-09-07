package queue;

import java.util.Stack;

/**
 * ClassName:RemoveDuplicates
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/7 8:17
 * @Version 1.0
 */
public class RemoveDuplicates {
    private Stack<Character> stack=new Stack<>();
    public String removeDuplicates(String s) {
        if (s.length()==1){
            return s;
        }
        char[] charArray = s.toCharArray();
        //字符串逆着遍历，避免新的字符串还要反转
        for (int i = charArray.length-1; i >=0 ; i--) {
            if (stack.isEmpty()){
                stack.push(charArray[i]);
            }
            else {
                char temp=stack.peek();
                if (temp!=charArray[i]){
                    stack.push(charArray[i]);
                }
                else {
                    stack.pop();
                }
            }
        }
        String result="";
        while (stack.isEmpty()==false){
            result+=stack.pop();
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates().removeDuplicates("abbaca"));
    }
}
