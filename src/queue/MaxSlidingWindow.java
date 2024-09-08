package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * ClassName:MaxSlidingWindow
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/7 9:25
 * @Version 1.0
 */
public class MaxSlidingWindow {
    //使用队列，存k个,更新后弹出第一个，每次统计队列的最大值
    // todo 自定义一个双端队列，队首永远是最大值。
    private Deque<Integer> deque=new ArrayDeque();
    private int index;
    public int[] maxSlidingWindow(int[] nums, int k) {
        //初始化
        int[] value=new int[nums.length-k+1];
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            int temp=nums[i];
            if (i<k){
                myPush(temp,i,k);
            }
            else {
                System.out.println("temp="+temp);
                System.out.println("deque.getFirst()="+deque.getFirst());
                value[j]=deque.getFirst();
                System.out.println("value="+value[j]);
                j++;
                if (temp==deque.getFirst()){
                    System.out.println("进去");
                    deque.pollFirst();
                }
                myPush(temp,i,k);
            }
        }
        value[j]=deque.getFirst();

        return value;
    }
    public void myPush(Integer temp,int i,int k){
        if (deque.isEmpty()){
            deque.push(temp);
            return;
        }
        if (i>index && i>k){
            deque.pollFirst();
        }
        while (deque.isEmpty()==false && temp>deque.getLast()){
            deque.pollLast();
        }
        deque.addLast(temp);
        while (deque.isEmpty()==false && temp>deque.getFirst()){
            deque.pollFirst();
        }
        if (temp.equals(deque.getFirst())){
            index=i;
        }
    }

    public static void main(String[] args) {
        int[] ints = new MaxSlidingWindow().maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
