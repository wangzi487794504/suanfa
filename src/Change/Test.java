package Change;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName:Test
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/6/5 9:22
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream=new FileInputStream("aa.txt");
        FileChannel fileChannel=inputStream.getChannel();
        //分配直接缓存区
        ByteBuffer buffer=ByteBuffer.allocateDirect(1024);
        buffer.put("aaaa".getBytes());
        //变为写出模式
        buffer.flip();
        fileChannel.read(buffer);
        String result=fileChannel.toString();


    }
}
class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        return null;
    }
}
