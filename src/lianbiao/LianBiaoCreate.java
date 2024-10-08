package lianbiao;

import org.junit.Test;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * ClassName:LianBiaoCreate
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/1/29 10:48
 * @Version 1.0
 */
public class LianBiaoCreate implements Iterable<Integer>{
    private  Node head;
    @Override
    public Iterator iterator() {
        return new Iterator() {
            Node temp=head;
            @Override
            public boolean hasNext() {
                return (temp!=null);
            }

            @Override
            public Integer next() {
                int value_temp=temp.value;
                temp=temp.next;
                return value_temp;
            }
        };
    }

    //组合关系，写成外部类和内部类，隐藏实现，只有内部类用了外部类的实例变量才不用static
    private static class Node{
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    //尾插
    public void latAdd(int value){
        if (head==null){
            head=new Node(value, null);
        }
        else{
            Node temp=lastNode();
            temp.next=new Node(value, null);
        }
    }
    //返回最后一个节点
    public Node lastNode(){
        if (head==null){
            return null;
        }
        else{
            Node temp=head;
            while (temp.next!=null){
                temp=temp.next;
            }
            return temp;
        }
    }
    //头插
    public void headAdd(int value){
//        if (head==null){
//            head=new Node(value, null);
//        }
//        else{
//            head=new Node(value, head);
//        }
        //这行代码已经能处理非空的情况了
        head=new Node(value, head);
    }
    public void loop(Consumer consumer){
        Node temp=head;
        while (temp!=null){
            consumer.accept(temp.value);
            temp=temp.next;
        }
    }
    public void loop2(Consumer consumer){
        for (Node temp=head;temp!=null;temp=temp.next){
            consumer.accept(temp.value);
        }
    }
    public Integer get (int index){
        for(Node temp=head;temp.next!=null;temp=temp.next){
            index--;
            if (index==-1){
                return temp.value;
            }
        }
        return null;
    }
    public Integer get2 (int index){
        int i=0;
        for(Node temp=head;temp.next!=null;temp=temp.next,i++){
            if (i==index){
                return temp.value;
            }
        }
        return null;
    }
    public int remove(int index){
        int i=0;
        if (index<0){
            throw new ArithmeticException("index不是正常范围");
        }
        for(Node temp=head;temp.next!=null;temp=temp.next,i++){
            if (i==(index-1)&& temp.next!=null){
                temp.next=temp.next.next;
                return 1;
            }
        }
        throw new ArithmeticException("index越界");
    }

}


