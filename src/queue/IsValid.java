package queue;

import java.util.Stack;

/**
 * ClassName:IsValid
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/6 23:27
 * @Version 1.0
 */
public class IsValid {
    //定义两个栈
    private Stack<Character> stack=new Stack<>();
    private Stack<Character> stack2=new Stack<>();
    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        for (int i = charArray.length-1; i >=0 ; i--) {
            stack.push(charArray[i]);
        }
        while (stack.isEmpty()==false){
            char a = stack.pop();
            if (stack2.isEmpty()){
                stack2.push(a);
            }
            else {
                char temp=stack2.peek();
                if (temp=='(' && a==')'){
                    stack2.pop();
                }
                else if (temp=='[' && a==']'){
                    stack2.pop();
                }
                else if (temp=='{' && a=='}'){
                    stack2.pop();
                }
                else {
                    stack2.push(a);
                }
            }
        }
        return stack2.isEmpty() && stack.isEmpty();
    }
}
