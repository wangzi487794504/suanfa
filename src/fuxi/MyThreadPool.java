package fuxi;

import test.A;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * ClassName:Test6
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/10/8 9:31
 * @Version 1.0
 */
public class MyThreadPool {
    //定义线程池，有一个返回就可以结束
    private ScheduledExecutorService executorService=new ScheduledThreadPoolExecutor(3);
    private CompletionService<Boolean> service=new ExecutorCompletionService(executorService);
    //要执行的任务提交给他
    public boolean mySubmit() throws InterruptedException, ExecutionException {
        for (int i = 0; i < 3; i++) {
            service.submit(()->{
                if (Math.random() > 0.5) {
                    return true;
                }
                System.out.println("method1失败");
                return false;
            });
        }
        System.out.println("aaa");
        for (int i = 0; i < 3; i++) {
            Future<Boolean> take = service.take();
            Boolean aBoolean = take.get();
            if (aBoolean){
                executorService.shutdown(); // 关闭线程池
                return  true;
            }
        }
        executorService.shutdown(); // 关闭线程池
        return false;
    }

    public static void main(String[] args) {
        try {
            System.out.println(new MyThreadPool().mySubmit());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
