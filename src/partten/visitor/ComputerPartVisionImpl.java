package partten.visitor;

/**
 * ClassName:ComputerPartVisionImpl
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/17 14:55
 * @Version 1.0
 */
public class ComputerPartVisionImpl implements ComputerPartVision {
    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("组装键盘");
    }

    @Override
    public void visit(Mouseboard mouseboard) {
        System.out.println("组装鼠标");
    }

    @Override
    public void visit(Computer computer) {
        System.out.println("组装电脑");
    }
}
