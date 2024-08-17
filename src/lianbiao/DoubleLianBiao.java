package lianbiao;

import java.util.function.Consumer;

/**
 * ClassName:DoubleLianBiao
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/1/30 21:43
 * @Version 1.0
 */
public class DoubleLianBiao {
    private Node solider=new Node(null, 0, null);
    static class Node{
        Node last;
        int value;
        Node next;
        public Node(Node last, int value, Node next) {
            this.last = last;
            this.value = value;
            this.next = next;
        }
    }
    public void add(int value){
        if (solider.next==null){
            solider.next=new Node(solider, value, null);
        }
        else {
            solider.next.last=new Node(solider, value, solider.next);
            solider.next=solider.next.last;
        }
    }
    public void loop(Consumer<Integer> consumer){
        Node temp=solider.next;
        while (temp!=null){
            consumer.accept(temp.value);
            temp=temp.next;
        }
    }
    private Node searchIndex(int index){
        int i=0;
        for (Node node=solider.next;node!=null;node=node.next,i++){
            if (i==index){
                return node;
            }
        }
        return null;
    }
    public void delete(int index){
        Node temp=searchIndex(index);
        if (temp==null){
            throw new ArithmeticException("数字异常");
        }
        else {
            temp.last.next=temp.next;
            temp.next.last=temp.last;
        }
    }
    public void insert(int value,int index){
        Node temp=searchIndex(index);
        if (temp==null){
            throw new ArithmeticException("数字异常");
        }
        else {
            temp.next.last=new Node(temp, value, temp.next);
            temp.next=temp.next.last;
        }
    }
}
