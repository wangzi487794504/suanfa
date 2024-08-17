package partten.strategy;

/**
 * ClassName:Operation
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/17 9:13
 * @Version 1.0
 */
public class Operation {
    private Strategy strategy;
    public Operation(Strategy strategy){
        this.strategy=strategy;
    }
    public int execute(int num1,int num2){
        return strategy.operation(num1, num2);
    }
}
