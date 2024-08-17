package partten.observer;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * ClassName:Subject
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/17 9:35
 * @Version 1.0
 */
@Data
public class Subject {
    List<MyObserver> observerList=new ArrayList<>();
    private int state;
    public void binding(MyObserver observer){
        observerList.add(observer);
    }
    public void notifyObservers(){
        observerList.forEach(a->{
            a.update();
        });
    }
}
