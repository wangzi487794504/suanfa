package partten.bridge;

/**
 * ClassName:Computer
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/13 22:03
 * @Version 1.0
 */
public abstract class Computer {
    protected Brand brand;

    public Computer(Brand brand) {
        this.brand = brand;
    }
    public void info(){
        brand.info();
    }
}
class Desktop extends Computer{
    public Desktop(Brand brand){
        super(brand);
    }
    @Override
    public void info(){
        super.info();
        System.out.println("台式机");
    }
}
class Loptop extends Computer{
    public Loptop(Brand brand){
        super(brand);
    }
    @Override
    public void info(){
        super.info();
        System.out.println("笔记本");
    }
}
