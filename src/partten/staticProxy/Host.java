package partten.staticProxy;

/**
 * ClassName:Host
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/13 22:23
 * @Version 1.0
 */
public class Host implements RentHouse{
    @Override
    public void rent() {
        System.out.println("房东出租房子");
    }
}
