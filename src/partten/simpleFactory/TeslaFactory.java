package partten.simpleFactory;

import partten.simpleFactory.bean.Tesla;
import partten.simpleFactory.mapper.Car;

/**
 * ClassName:TeslaFactory
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/11 21:26
 * @Version 1.0
 */
public class TeslaFactory implements CarFactory{
    @Override
    public Car getCar(String car) {
        return new Tesla();
    }
}
