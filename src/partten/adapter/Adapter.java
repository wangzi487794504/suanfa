package partten.adapter;

/**
 * ClassName:Adapter
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/13 21:36
 * @Version 1.0
 */
public class Adapter implements NetToUsb{
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handleRequesr() {
       adaptee.inter();
    }
}
