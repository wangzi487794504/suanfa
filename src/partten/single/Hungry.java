package partten.single;

/**
 * ClassName:Hungry
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/14 14:53
 * @Version 1.0
 */
public class Hungry {
    private Hungry(){

    }
    private final static Hungry HUNGRY=new Hungry();
    public static Hungry getInstance(){
        return HUNGRY;
    }
}
