package Change;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ClassName:ReadAndWrite
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/6/3 19:53
 * @Version 1.0
 */
public class ReadAndWrite {


    public static void main(String[] args) {
        BlockingQueue blockingQueue=new ArrayBlockingQueue(5);
        Data4 data4=new Data4();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data4.add(i);
            }
        },"a").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data4.add(i);
            }
        },"b").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                data4.read(i);
            }
        },"c").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                data4.read(i);
            }
        },"d").start();
    }

}

//我应该创建一个集合允许写入和删除
class Data4{
    private CopyOnWriteArrayList list=new CopyOnWriteArrayList();
    private ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    public void add(int index){
        //要支持并发
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+index);
            list.add(index, index);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
    public void read(int index){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+index);
            list.get(index);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
