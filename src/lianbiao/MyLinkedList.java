package lianbiao;

import partten.bridge.Brand;

/**
 * ClassName:MyLinkedList
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/5 8:48
 * @Version 1.0
 */
public class MyLinkedList {
    private ListNode listNode;
    public MyLinkedList() {
    }

    public int get(int index) {
        ListNode temp=listNode;
       while (index>0 && temp!=null){
            temp=temp.next;
            index--;
        }
       if (index>0  || temp==null){
           return -1;
       }
        return temp.val;
    }

    public void addAtHead(int val) {
        if (listNode==null){
            listNode=new ListNode(val);
            return;
        }
        ListNode head=new ListNode(val);
        head.next=listNode;
        listNode=head;
    }

    public void addAtTail(int val) {
        if (listNode==null){
            listNode=new ListNode(val);
            return;
        }
        ListNode head=new ListNode(val);
        ListNode temp=listNode;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=head;
    }

    public void addAtIndex(int index, int val) {
        if (listNode==null){
            if (index>0){
                return;
            }
            listNode=new ListNode(val);
            return;
        }
        ListNode head=new ListNode(val);
        if (index==0){
            addAtHead(val);
        }
        //哨兵
        ListNode guard=new ListNode();
        guard.next=listNode;
        ListNode temp=guard;
        while (index>0 && temp.next!=null){
            temp=temp.next;
            index--;
        }
        if (index>0){
            return;
        }
        if (temp.next!=null){
            head.next=temp.next;
        }
        temp.next=head;
    }

    public void deleteAtIndex(int index) {
        ListNode guard=new ListNode();
        guard.next=listNode;
        ListNode temp=guard;
        while (index>0 && temp.next!=null){
            temp=temp.next;
            index--;
        }
        if (index>0 || temp.next==null){
            return;
        }
        temp.next=temp.next.next;
        listNode=guard.next;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.binali(myLinkedList);
        System.out.println("begin");
        myLinkedList.addAtIndex(1, 0);    // 链表变为 1->2->3
        myLinkedList.binali(myLinkedList);
        System.out.println(myLinkedList.get(0));              // 返回 2
    }
    public void binali(MyLinkedList myLinkedList){
        ListNode temp=myLinkedList.listNode;
        while (temp!=null){
            System.out.print(temp.val);
            temp=temp.next;
        }
        System.out.println("\n");
    }
}
