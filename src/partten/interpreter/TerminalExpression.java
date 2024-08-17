package partten.interpreter;

/**
 * ClassName:TerminalExpression
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/17 9:24
 * @Version 1.0
 */
public class TerminalExpression implements Expression{
    private String data;
    public TerminalExpression(String data){
        this.data=data;
    }
    @Override
    public boolean interpret(String context) {
        if (context.contains(data)){
            return true;
        }
        return false;
    }
}
