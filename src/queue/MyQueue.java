package queue;

import java.util.Stack;

/**
 * ClassName:MyQueue
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/6 22:06
 * @Version 1.0
 */
public class MyQueue {
    //定义一个入栈
    private Stack<Integer> inStack=new Stack<>();
    private Stack<Integer> outStack=new Stack<>();
    //定义一个出栈
    public MyQueue() {

    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        while (inStack.isEmpty()==false){
            outStack.push(inStack.pop());
        }
        int result=outStack.pop();
        while (outStack.isEmpty()==false){
            inStack.push(outStack.pop());
        }
        return result;
    }

    public int peek() {
        while (inStack.isEmpty()==false){
            outStack.push(inStack.pop());
        }
        int result=outStack.peek();
        while (outStack.isEmpty()==false){
            inStack.push(outStack.pop());
        }
        return result;
    }

    public boolean empty() {
        return inStack.empty();
    }
}
