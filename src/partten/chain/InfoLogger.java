package partten.chain;

/**
 * ClassName:InfoLogger
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/17 14:20
 * @Version 1.0
 */
public class InfoLogger extends AbstractLogger{
    public InfoLogger(int level){
        this.level=level;
    }
    @Override
    protected void write(String message) {
        System.out.println("INFO>>>>"+message);
    }
}
