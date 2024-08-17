package partten.prototype;

import java.util.Date;

/**
 * ClassName:BiliBili
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/13 21:09
 * @Version 1.0
 */
public class BiliBili {
    public static void main(String[] args) throws CloneNotSupportedException {
        //原型对象
        Date date = new Date();
        Vidio vidio=new Vidio("原型",date);
        System.out.println(vidio);
        System.out.println(vidio.hashCode());

        //克隆
        Vidio clone = (Vidio) vidio.clone();
    }
}
