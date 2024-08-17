package partten.build;

/**
 * ClassName:Builder
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/11 22:09
 * @Version 1.0
 */
public abstract class Builder {
    abstract void buildA();
    abstract void buildB();
    abstract void buildC();
    abstract void buildD();
    abstract Product getProductor();
}
