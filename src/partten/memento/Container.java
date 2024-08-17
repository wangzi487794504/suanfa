package partten.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:Container
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/17 10:30
 * @Version 1.0
 */
public class Container {
    public List<Order> orderList=new ArrayList<>();
    public void add(Order order){
        orderList.add(order);
    }
    public Order get(Integer index){
        return orderList.get(index);
    }
}
