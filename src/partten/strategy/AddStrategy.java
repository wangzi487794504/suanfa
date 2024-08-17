package partten.strategy;

/**
 * ClassName:AddStrategy
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/17 9:07
 * @Version 1.0
 */
public class AddStrategy implements Strategy {
    @Override
    public int operation(int num1, int num2) {
        return num1+num2;
    }
}
