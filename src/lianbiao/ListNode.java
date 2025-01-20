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
    public int val;
    public lianbiao.ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, lianbiao.ListNode next) { this.val = val; this.next = next; }
}
