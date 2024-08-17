package partten.visitor;

/**
 * ClassName:Computer
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/17 14:49
 * @Version 1.0
 */
public class Computer implements ComputerPart {
    ComputerPart[] parts=new ComputerPart[]{new Keyboard(),new Mouseboard()};
    @Override
    public void accept(ComputerPartVision part) {
        for (ComputerPart computerPart : parts) {
            computerPart.accept(part);
        }
        part.visit(this);
    }
}
