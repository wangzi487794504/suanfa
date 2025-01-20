package tanxinsuanfa;

import partten.simpleFactory.mapper.Car;

import java.util.*;

/**
 * ClassName:Main
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/21 16:25
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        //输入
        Scanner scanner = new Scanner(System.in);
        //汽车数量
        int total=scanner.nextInt();
        int totalTemp=total;
        //维护一个数组
        Car[] cars=new Car[total];
        //保存对象
        int i=0;
        while (totalTemp-->0){
            //每个骑车的坐标和速度
            int position= scanner.nextInt();
            int speed= scanner.nextInt();
            cars[i++]=new Car(position,speed);
        }
        //按位置排序
        //追尾就算有问题
        Arrays.sort(cars, (o1,o2)->Integer.compare(o2.position, o1.position));
        //定义一个集合
        List<Car> list=new ArrayList<>();
        for (Car car : cars) {
            if (list.isEmpty() || isZhuiWei(car, list.get(list.size()-1))){
                list.add(car);
            }
        }
        System.out.println(total-list.size());
    }
    public static boolean isZhuiWei(Car car1,Car car2){
        if (car1.speed<=car2.speed){
            return true;
        }
        //速度差值
        int speedReduce = car1.speed - car2.speed;
        //速度差值
        int positionReduce = car2.position - car1.position;
        return speedReduce<=0 || (positionReduce>0 && speedReduce>0);
    }
    //内部类
    static class Car{
        int position;
        int speed;
        public Car(int position,int speed){
            this.position=position;
            this.speed=speed;
        }
    }
}
