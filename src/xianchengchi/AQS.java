package xianchengchi;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * ClassName:AQS
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/1 11:10
 * @Version 1.0
 */
public class AQS {
}
//自定义锁
class MyLock implements Lock {
    //独占锁
    class MySync extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return super.isHeldExclusively();
        }
        public Condition newCondition(){
            return new ConditionObject();
        }
    }
    //加锁，不成功会进等待序列
    @Override
    public void lock() {
        sync.acquire(1);
    }
    //可打断的加锁
    @Override
    public void lockInterruptibly() throws InterruptedException {

    }
    private MySync sync=new MySync();
    //尝试加锁，一次
    @Override
    public boolean tryLock() {
        return false;
    }
    //尝试加锁，带时间
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
