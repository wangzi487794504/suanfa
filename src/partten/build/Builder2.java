package partten.build;

/**
 * ClassName:Builder2
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/13 20:50
 * @Version 1.0
 */
public abstract class Builder2 {
    abstract Builder2 buildA(String msg);
    abstract Builder2 buildB(String msg);
    abstract Builder2 buildC(String msg);
    abstract Builder2 buildD(String msg);
    abstract Product getProductor();
}
