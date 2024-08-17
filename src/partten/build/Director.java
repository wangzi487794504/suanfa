package partten.build;

/**
 * ClassName:Director
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/11 22:15
 * @Version 1.0
 */
public class Director {
    public Product build(Builder builder){
        builder.buildA();
        builder.buildB();
        builder.buildB();
        builder.buildD();
        return builder.getProductor();
    }
}
