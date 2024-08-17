package partten.observer;

/**
 * ClassName:MyObserver
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/17 9:36
 * @Version 1.0
 */
public abstract class MyObserver {
    protected Subject subject;
    public abstract void update();
}
