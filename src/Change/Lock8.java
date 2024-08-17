package Change;

import java.util.concurrent.Callable;

/**
 * ClassName:Lock8
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/6/3 16:59
 * @Version 1.0
 */
public class Lock8  {

    public static void main(String[] args) {
        Phone phone=new Phone();
        new Thread(()->{
            phone.sendSms();
        },"a").start();
        new Thread(()->{
            phone.call();
        },"b").start();
    }
}
class Phone{
    public synchronized void sendSms(){
        System.out.println("sendSms");
    }
    public synchronized void call(){
        System.out.println("call");
    }
}
