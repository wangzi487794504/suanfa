package partten.single;

/**
 * ClassName:Lazy
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/14 14:56
 * @Version 1.0
 */
public class Lazy {
    private Lazy(){
        //防止通过构造器二次创建，但是防止不了多个线程一起去第一次创建
        synchronized (Lazy.class){
            if (lazy!=null){
                throw new RuntimeException("不要用反射");
            }
        }
    }
    //避免new的时候指令重排
    private volatile   static Lazy lazy;
    //DCL懒汉式
    public static Lazy getInstance(){
        if(lazy==null){
            synchronized (Lazy.class){
                if (lazy==null){
                    lazy=new Lazy();
                }
            }
        }
        return lazy;
    }
}
