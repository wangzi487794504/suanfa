package thread;

import javafx.concurrent.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName:Print3
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/10/3 9:59
 * @Version 1.0
 */
public class Print3 {
    private static final ReentrantLock LOCK=new ReentrantLock();
    private static final int MAX=100;
    private static int count=0;

    public static void main(String[] args) {
        List<Condition> list=new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i,LOCK.newCondition());
            MyThread myThread = new MyThread(i, list);
            myThread.start();
        }
    }
    static class MyThread extends Thread{
        private int index;
        List<Condition> list;
        public MyThread(int index,List<Condition> list) {
            this.index=index;
            this.list=list;
        }
        private void signalNext(){
            int nextIndex = (index + 1) % list.size();
            list.get(nextIndex).signal();
        }
        @Override
        public void run() {
            while (count<=MAX){
                LOCK.lock();
                try {
                    if (count%3!=index){
                        list.get(index).await();
                    }
                    if (count > 100) {
                        // 唤醒下一个线程，保证程序正常退出
                        signalNext();
                        // 退出循环 线程运行结束
                        return;
                    }
                    System.out.println((Thread.currentThread().getName() + " " + count));
                    // 计数器+1
                    count ++;
                    // 通知下一个干活
                    signalNext();
                } catch (Exception e){
                    System.out.println(e);
                }
                finally {
                    LOCK.unlock();
                }
            }
        }
    }
}
