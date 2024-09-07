package lianbiao;

/**
 * ClassName:ListNode
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/4 19:20
 * @Version 1.0
 */
public class ListNode {
    int val;
    lianbiao.ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, lianbiao.ListNode next) { this.val = val; this.next = next; }
}
