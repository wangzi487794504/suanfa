//package xianchengchi;
//
//import jdk.internal.org.objectweb.asm.tree.LocalVariableAnnotationNode;
//
//import java.util.ArrayDeque;
//import java.util.Deque;
//import java.util.HashSet;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * ClassName:TestPool
// * Package:
// * Description:
// *
// * @Aurhor 王子杰
// * @Create 2024/7/31 15:59
// * @Version 1.0
// */
//public class TestPool {
//}
//class BlockingQueue<T>{
//    //任务队列
//    private Deque<T> queue=new ArrayDeque<>();
//
//    //锁
//    private ReentrantLock lock=new ReentrantLock();
//
//    //生产者的条件变量
//    private Condition fullWaitSet=lock.newCondition();
//    //消费者条件变量
//    private Condition emptyWaitSet= lock.newCondition();
//
//    //容量
//    private int capcity;
//
//    public BlockingQueue(int capcity) {
//        this.capcity = capcity;
//    }
//
//    //take方法，获取
//    public T take(){
//        lock.lock();
//        try {
//            while (queue.isEmpty()){
//                //空需要等待
//                emptyWaitSet.await();
//            }
//            //获取队列头的元素
//            T t = queue.removeFirst();
//            //唤醒
//            fullWaitSet.signal();
//            return t;
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } finally {
//            lock.unlock();
//        }
//    }
//    //阻塞添加
//    public void put(T element){
//        lock.lock();
//        try {
//            while (queue.size()==capcity){
//                fullWaitSet.await();
//            }
//            queue.push(element);
//            //唤醒阻塞的
//            emptyWaitSet.signal();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    //超时等待过去
//    public T poll(long timeout, TimeUnit unit){
//        lock.lock();
//        try {
//            //将timeout统一转换为纳秒
//            long nanos=unit.toNanos(timeout);
//            while (queue.isEmpty()){
//                //空需要等待
//                if (nanos<=0){
//                    return null;
//                }
//                nanos=emptyWaitSet.awaitNanos(nanos);
//            }
//            //获取队列头的元素
//            T t = queue.removeFirst();
//            //唤醒
//            fullWaitSet.signal();
//            return t;
//
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } finally {
//            lock.unlock();
//        }
//    }
//    //超时阻塞添加
//    public boolean offer(T task, long timeout, TimeUnit timeUnit){
//        lock.lock();
//        try {
//            //将timeout统一转换为纳秒
//            long nanos=timeUnit.toNanos(timeout);
//            while (queue.isEmpty()){
//                //空需要等待
//                if (nanos<=0){
//                    return false;
//                }
//                nanos=emptyWaitSet.awaitNanos(nanos);
//            }
//            queue.addLast(task);
//            //唤醒
//            fullWaitSet.signal();
//            return true;
//
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public void tryPut(RejectPolicy<T> rejectPolicy, T task) {
//        lock.lock();
//        try {
//            //判断队列是否满
//            if (queue.size()==capcity) {
//                rejectPolicy.reject(this, task);
//            }
//        }
//        finally {
//
//        }
//    }
//}
//}
//class ThreadPool {
//    //任务队列
//    private BlockingQueue<Runnable> taskQueue;
//    //线程集合
//    private HashSet<Work> works = new HashSet();
//
//    //核心线程数
//    private int coreSize;
//
//    //队列容量
//    private int queueCapcity;
//
//    //获取任务的超时时间
//    private long timeout;
//    private TimeUnit timeUnit;
//
//    //拒绝策略
//    private RejectPolicy<Runnable> rejectPolicy;
//
//    public ThreadPool(BlockingQueue<Runnable> taskQueue, int coreSize, int queueCapcity, long timeout, TimeUnit timeUnit,RejectPolicy<Runnable> rejectPolicy) {
//        this.taskQueue = taskQueue;
//        this.coreSize = coreSize;
//        this.queueCapcity = queueCapcity;
//        this.timeout = timeout;
//        this.timeUnit = timeUnit;
//        this.rejectPolicy=rejectPolicy;
//    }
//
//    class Work extends Thread {
//        private Runnable task;
//
//        public Work(Runnable task) {
//            this.task = task;
//        }
//
//        @Override
//        public void run() {
//            while (task != null || (task = taskQueue.take()) != null) {
//                try {
//                    task.run();
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                } finally {
//                    task = null;
//                }
//            }
//            synchronized (works) {
//                works.remove(this);
//            }
//            //没有任务，从任务队列获取任务
//        }
//    }
//
//    public void execute(Runnable task) {
//        //当任务数没有超过coresize时，就直接交给worker
//        //当任务数超过coresize时，就加入任务队列暂停
//        synchronized (works) {
//            if (works.size() < coreSize) {
//                Work work = new Work(task);
//                work.start();
//            } else {
//                taskQueue.put(task);
//                //四等
//                //超时等待
//                //放弃任务
//                //抛出异常
//                //调用者自己执行
//                taskQueue.tryPut(rejectPolicy,task);
//            }
//        }
//    }
//
//}
//interface RejectPolicy<T>{
//    void reject(BlockingQueue<T> queue,T task);
//}