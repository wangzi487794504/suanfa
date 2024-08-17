package partten.template;

/**
 * ClassName:DesignPatternClass
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/16 17:11
 * @Version 1.0
 */
public class DesignPatternClass extends AClass{
    private boolean flag;
    public DesignPatternClass(boolean flag){
        this.flag=flag;
    }
    @Override
    public boolean flag() {
        return this.flag;
    }
    @Override
    public void ismakeNote() {
        System.out.println("子类");
    }
}
