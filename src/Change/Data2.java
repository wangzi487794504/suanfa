package Change;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName:Data2
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/6/3 16:23
 * @Version 1.0
 */
public class Data2 {
    Lock lock=new ReentrantLock();
    private int num=0;
    Condition condition=lock.newCondition();
    public void increment() throws InterruptedException {
        while (num!=0){
            condition.await();
        }
        num++;
        condition.notifyAll();
        System.out.println(Thread.currentThread().getName());
    }
    public void decrement(){
        lock.lock();
        try {
            while (num!=0){
                condition.await();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
class C {
    public static void main(String[] args) {
        Data3 data3=new Data3();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data3.printA();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data3.printB();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data3.printC();
            }
        },"C").start();
    }
}
class Data3{
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    private Condition condition2=lock.newCondition();
    private Condition condition3=lock.newCondition();
    private int num=1;
    public void printA(){
        lock.lock();
        try {
            while (num!=1){
                condition.await();
            }
            System.out.println(Thread.currentThread().getName()+"aaa");
            //可以不用notifyAll唤醒所有，可以具体的唤醒
            num=2;
            condition2.signal();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
    public void printB(){
        lock.lock();
        try {
            while (num!=2){
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName()+"bbb");
            num=3;
            condition3.signal();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
    public void printC(){
        lock.lock();
        try {
            while (num!=3){
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName()+"ccc");
            num=1;
            condition.signal();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
