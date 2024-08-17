package partten.visitor;

/**
 * ClassName:Keyboard
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/17 14:46
 * @Version 1.0
 */
public class Keyboard implements ComputerPart {
    @Override
    public void accept(ComputerPartVision part) {
        part.visit(this);
    }
}
