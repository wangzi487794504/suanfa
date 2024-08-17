package partten.visitor;

/**
 * ClassName:ComputerPartVision
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/17 14:45
 * @Version 1.0
 */
public interface ComputerPartVision {
    void visit(Keyboard keyboard);

    void visit(Mouseboard mouseboard);

    void visit(Computer computer);
}
