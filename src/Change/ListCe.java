package Change;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.FutureTask;

/**
 * ClassName:ListCe
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/6/3 17:22
 * @Version 1.0
 */
public class ListCe {
    final int temp=5;
    public static void main(String[] args) {
        //故障现象：ConcurrentModificationException
//        List<String> list = new Vector<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>
//                ());

        List<String> list = new CopyOnWriteArrayList<>();
//        FutureTask futureTask=new FutureTask();
    }
}
