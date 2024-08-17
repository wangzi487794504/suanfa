package partten.chain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * ClassName:AbstractLogger
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/17 11:40
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractLogger {
    public static int INFO=1;
    public static int DEBUG=2;
    public static int ERROR=3;
    protected AbstractLogger nextLogger;
    protected int level;
    public  void setNextLogger(AbstractLogger nextLogger){
        this.nextLogger=nextLogger;
    }
    public void logMessage(int level,String message){
        if (this.level<=level){
            write(message);
        }
        if (nextLogger!=null){
            //调用责任链的下一个
            nextLogger.logMessage(level, message);
        }
    }
    protected abstract void write(String message);

}
