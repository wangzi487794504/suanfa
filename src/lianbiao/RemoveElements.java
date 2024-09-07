package lianbiao;

/**
 * ClassName:RemoveElements
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/5 8:22
 * @Version 1.0
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        //TODO 思路：使用一个中间变量保存，如果有，跳到下一个
        // todo 最麻烦的是第一个就是的，最好用哨兵
        ListNode listNode=new ListNode();
        listNode.next=head;
        head=listNode;
        while (listNode.next!=null){
            if (listNode.next.val==val){
                listNode.next=listNode.next.next;
            }
            else {
                listNode=listNode.next;
            }
        }
        return head.next;
    }
}
