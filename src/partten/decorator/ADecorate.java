package partten.decorator;

/**
 * ClassName:ADecorate
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/15 21:29
 * @Version 1.0
 */
public abstract class ADecorate extends ABatterCake {
    private ABatterCake aBatterCake;

    public ADecorate(ABatterCake aBatterCake) {
        this.aBatterCake = aBatterCake;
    }

    @Override
    protected String getInfo() {
        return aBatterCake.getInfo();
    }

    @Override
    protected String cost() {
        return aBatterCake.cost();
    }
}
