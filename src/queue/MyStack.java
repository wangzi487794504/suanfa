package queue;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ClassName:MyStack
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/6 22:53
 * @Version 1.0
 */
public class MyStack {
    private Queue<Integer> queue=new LinkedBlockingQueue<>();
    private Queue<Integer> queue2=new LinkedBlockingQueue<>();
    public MyStack() {

    }

    public void push(int x) {
        if (queue.isEmpty()==true && queue2.isEmpty()==false){
            queue2.add(x);
            return;
        }
        queue.add(x);
    }

    public int pop() {
        while (queue.size()!=1){
            queue2.add(queue.poll());
        }
        int result= queue.poll();
        Queue<Integer> tempQueue=queue;
        queue=queue2;
        queue2=tempQueue;
        return result;
    }

    public int top() {
        int temp=0;
        while (queue.isEmpty()==false){
            temp=queue.poll();
            System.out.println(temp);
            queue2.add(temp);
        }
        Queue<Integer> tempQueue=queue;
        queue=queue2;
        queue2=tempQueue;
        return temp;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
