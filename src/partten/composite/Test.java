package partten.composite;

/**
 * ClassName:Test
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/15 21:08
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Employee ceo=new Employee("张三","1",2000L);
        Employee mange=new Employee("李四","2",2000L);
        Employee sallec=new Employee("王五","3",2000L);
        Employee sallec2=new Employee("赵六","4",2000L);
        Employee store=new Employee("陈七","5",2000L);

        //添加层级关系
        ceo.add(mange);
        mange.add(sallec);
        mange.add(sallec2);
        mange.add(store);
    }
}
