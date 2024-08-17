package hash;

import lombok.Data;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * ClassName:TwoSum
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/7/30 21:44
 * @Version 1.0
 */
public class TwoSum {
//    public int[] twoSum(int[] nums, int target) {
//        //去重
//        //计算
//
//    }

    public static void main(String[] args) throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        //这样会报Exception in thread "main" java.lang.SecurityException: Unsafe
        //Unsafe unsafe = Unsafe.getUnsafe();
        //方法一
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);
        // 1. 获取域的偏移地址
        long idOffset = unsafe.objectFieldOffset(Teacher.class.getDeclaredField("id"));
        long nameOffset = unsafe.objectFieldOffset(Teacher.class.getDeclaredField("name"));
        Teacher t = new Teacher();
        System.out.println(t);
        // 2. 执行 cas 操作
        unsafe.compareAndSwapInt(t, idOffset, 0, 1);
        unsafe.compareAndSwapObject(t, nameOffset, null, "张三");
        // 3. 验证
        System.out.println(t);
    }
}
@Data
class Teacher {
    volatile int id;
    volatile String name;
}
