package Change;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName:LianBiaoJiaoHuan
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/6/2 15:19
 * @Version 1.0
 */
public class LianBiaoJiaoHuan {
    public ListNode swapPairs(ListNode head) {
        ListNode domNode=new ListNode();
        domNode.next=head;
        ListNode contemp=new ListNode();
        contemp=domNode;
        while (contemp.next!=null && contemp.next.next!=null){
            ListNode firstTemp=new ListNode();
            ListNode secondTemp=new ListNode();
            //第一步，先保存第一个节点
            firstTemp=contemp.next;
            //第二步，保存第三个节点
            secondTemp=contemp.next.next.next;
            //开始交换
            contemp.next=contemp.next.next;
            contemp.next.next=firstTemp;
            firstTemp.next=secondTemp;
            contemp=contemp.next.next;
        }
        return domNode.next;
    }
    //要求删除倒数第n个节点，这种采用双指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode domNode=new ListNode();
        domNode.next=head;
        ListNode conTemp= new ListNode();
        ListNode secondTemp=new ListNode();
        conTemp=domNode;
        secondTemp=domNode;
        //因为有个虚拟节点，相当于真实节点的n-1
        while (n>0 && secondTemp.next!=null){
            n--;
            secondTemp=secondTemp.next;
        }
        while (secondTemp.next!=null){
            conTemp=conTemp.next;
            secondTemp=secondTemp.next;
        }
        conTemp.next=conTemp.next.next;
        return domNode.next;
    }
    //判断有没有回路，如果有返回第一个回路节点
    public ListNode detectCycle(ListNode head) {
        //首先定义快指针和慢指针
        ListNode fastNode=new ListNode();
        ListNode slowNode=new ListNode();
        fastNode=head;
        slowNode=head;
        while (fastNode!=null && fastNode.next!=null){
            //相当于每次比他快一步
            fastNode=fastNode.next.next;
            slowNode=slowNode.next;
            if (fastNode==slowNode){
                //相遇之后，根据公式求相遇节点
                fastNode=head;
                while (fastNode!=slowNode){
                    fastNode=fastNode.next;
                    slowNode=slowNode.next;
                    Lock lock=new ReentrantLock();
                }
                return fastNode;
            }
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
