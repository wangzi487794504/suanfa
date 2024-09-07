package lianbiao;


/**
 * ClassName:ReverseList
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/4 19:15
 * @Version 1.0
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;  // 前一个节点
        ListNode curr = head;  // 当前节点

        while (curr != null) {
            ListNode nextTemp = curr.next;  // 暂存当前节点的下一个节点
            curr.next = prev;                // 反转当前节点的指针
            prev = curr;                     // 移动前一个节点到当前节点
            curr = nextTemp;                 // 移动到下一个节点
        }
        return prev;  // 返回新的头节点
    }
    public ListNode reverseList2(ListNode head){
        ListNode pre=null;
        ListNode curr=head;
        while (curr!=null){
            ListNode temp=curr.next;
            curr.next=pre;
            pre=curr;
            curr=temp;
        }
        return pre;
    }
    public static void main(String[] args) {
        ListNode node5=new ListNode(1);
        ListNode node4=new ListNode(2,node5);
        ListNode node3=new ListNode(3,node4);
        ListNode node2=new ListNode(4,node3);
        ListNode node=new ListNode(5,node2);
        ListNode node1 = new ReverseList().reverseList(node);
        while (node1!=null){
            System.out.println(node1.val);
            node1=node1.next;
        }
    }
}
