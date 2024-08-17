package partten.simpleFactory;

import partten.simpleFactory.bean.Tesla;
import partten.simpleFactory.mapper.Car;

/**
 * ClassName:CarFactory
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/11 21:18
 * @Version 1.0
 */
public interface CarFactory {
    Car getCar(String car);
}
