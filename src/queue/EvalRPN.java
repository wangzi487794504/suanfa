package queue;

import java.util.Stack;

/**
 * ClassName:EvalRPN
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/7 9:07
 * @Version 1.0
 */
public class EvalRPN {
    private Stack<String> stack=new Stack();
    public int evalRPN(String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            String temp=tokens[i];
            if (stack.isEmpty()){
                stack.push(temp);
            }
            else {
                if ("+".equals(temp)){
                    Integer a= Integer.valueOf(stack.pop());
                    Integer b= Integer.valueOf(stack.pop());
                    //注意顺序
                    stack.push(String.valueOf(b+a));
                } else if ("-".equals(temp)) {
                    Integer a= Integer.valueOf(stack.pop());
                    Integer b= Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(b-a));
                } else if ("*".equals(temp)) {
                    Integer a= Integer.valueOf(stack.pop());
                    Integer b= Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(a*b));
                }else if ("/".equals(temp)){
                    Integer a= Integer.valueOf(stack.pop());
                    Integer b= Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(b/a));
                }
                else {
                    stack.push(temp);
                }
            }
        }
        return Integer.valueOf( stack.pop());
    }
}
