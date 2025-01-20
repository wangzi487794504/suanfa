package fuxi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * ClassName:Test6
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/10/8 9:31
 * @Version 1.0
 */
public class Saima {
    private static CountDownLatch count=new CountDownLatch(1);
    private static List<String> list= Collections.synchronizedList(new ArrayList<>());
    //10个马都到达才唤醒
    private static CyclicBarrier cyclicBarrier=new CyclicBarrier(10, new Runnable() {
        @Override
        public void run() {
            System.out.println("成绩");
            for (String s : list) {
                System.out.println(s);
            }
        }
    });
    static class House implements Runnable{
        private String name;

        public House(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                //等待命令
                System.out.println("aa");
                count.await();
                //每个马运行时长
                Thread.sleep((long) (1000* Math.random()));
                //记录到达终点的吗
                list.add(name);
                //等待所有的码都到
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new House("第"+i+"个")).start();
        }
        System.out.println("就绪");
        count.countDown();
    }
}
