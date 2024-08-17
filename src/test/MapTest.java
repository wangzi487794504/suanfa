package test;

import org.junit.Test;

import java.util.HashMap;

/**
 * ClassName:MapTest
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/11 9:08
 * @Version 1.0
 */
public class MapTest {
    private HashMap<Integer,Integer> hashMapFirst=new HashMap<>();
    @Test
    public void test1(){
        hashMapFirst.put(2, 1);
        hashMapFirst.put(2,2);
        System.out.println(hashMapFirst.get(2));
    }
}
