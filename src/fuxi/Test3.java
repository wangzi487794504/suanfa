package fuxi;

import java.util.concurrent.atomic.AtomicReference;

/**
 * ClassName:Test1
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/10/4 10:30
 * @Version 1.0
 */
public class Test3 {
    private static final AtomicReference<Test3> INSTANCE=new AtomicReference<>();
    private Test3(){

    }
    public  static Test3 getInstance(){
        for(;;){
            Test3 test3 = INSTANCE.get();
            if (null!=test3){
                return test3;
            }
            test3=new Test3();
            if (INSTANCE.compareAndSet(null, test3)){
                return test3;
            }
        }
    }


}
