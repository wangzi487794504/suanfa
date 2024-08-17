package partten.state;

import lombok.Data;

/**
 * ClassName:Context
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/17 15:13
 * @Version 1.0
 */
@Data
public class Context {
    private State state;
    public Context(){
        this.state=null;
    }
}
