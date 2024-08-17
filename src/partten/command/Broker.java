package partten.command;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:Broker
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/17 11:02
 * @Version 1.0
 */
public class Broker {
    List<Order> orderList=new ArrayList<>();
    public void takeOrder(Order order){
        orderList.add(order);
    }
    public void placeOrder(){
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
