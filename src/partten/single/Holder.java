package partten.single;

/**
 * ClassName:Holder
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/14 15:10
 * @Version 1.0
 */
public class Holder {
    private Holder (
    ){}
    public static Holder getInstance(){
        return new Holder();
    }
    public static class  InnerClass{
        private static final Holder HOLDER=new Holder();
    }
}
