package partten.command;

import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * ClassName:BuyStock
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/17 10:57
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
public class BuyStock implements Order {
    private Stock aaaStock;
    @Override
    public void execute() {
        aaaStock.buy();
    }
}
