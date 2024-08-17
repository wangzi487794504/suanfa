package lianbiao;

import org.junit.Test;

import java.sql.SQLOutput;

/**
 * ClassName:LianBiaoTest
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/1/29 13:39
 * @Version 1.0
 */
public class LianBiaoTest {
    @Test
    public void test()  {
        Class<LianBiaoCreate> c = LianBiaoCreate.class;
        LianBiaoCreate lianBiao= null;
        try {
            lianBiao = c.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        lianBiao.headAdd(1);
        lianBiao.headAdd(2);
        lianBiao.headAdd(3);
        lianBiao.headAdd(4);
        lianBiao.loop(value->{
            System.out.println(value);
        });

        lianBiao.latAdd(5);
        for (Integer integer : lianBiao) {
            System.out.println(integer);
        }
        System.out.println(lianBiao.get(2));
    }
    @Test
    public void test2(){
        DoubleLianBiao doubleLianBiao=new DoubleLianBiao();
        doubleLianBiao.add(1);
        doubleLianBiao.add(2);
        doubleLianBiao.add(3);
        doubleLianBiao.add(4);
        doubleLianBiao.loop(value->{
            System.out.println(value);
        });
        doubleLianBiao.delete(2);
        doubleLianBiao.loop(value->{
            System.out.println(value);
        });
        doubleLianBiao.insert(2, 1);
        doubleLianBiao.loop(value->{
            System.out.println(value);
        });
    }
}
