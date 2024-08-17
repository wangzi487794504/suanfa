package partten.chain;

/**
 * ClassName:Test
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/17 14:26
 * @Version 1.0
 */
public class Test {
    public static AbstractLogger getChainLogger(){
        AbstractLogger info=new InfoLogger(AbstractLogger.INFO);
        AbstractLogger debug=new DebugLogger(AbstractLogger.DEBUG);
        //设置链路
        info.setNextLogger(debug);
        return info;
    }
}
