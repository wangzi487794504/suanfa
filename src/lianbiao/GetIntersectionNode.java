package lianbiao;

/**
 * ClassName:GetIntersectionNode
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/5 10:14
 * @Version 1.0
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //todo 移动到他们两个相同的位置再比较
        int lengthA=0;
        int lengthB=0;
        ListNode tempA=headA;
        ListNode tempB=headB;
        while (tempA!=null){
            tempA=tempA.next;
            lengthA++;
        }
        while (tempB!=null){
            tempB=tempB.next;
            lengthB++;
        }
        int offset=Math.abs(lengthA-lengthB);
        //重置临时节点
        tempB=headB;
        tempA=headA;
        if (lengthA>lengthB){
            while (offset>0){
                tempA=tempA.next;
                offset--;
            }
        }
        else {
            while (offset>0){
                tempB=tempB.next;
                offset--;
            }
        }
        while (tempA != null) {
            if (tempA == tempB) {
                return tempA;
            }
            tempA = tempA.next;
            tempB=tempB.next;
        }
        return null;
    }
}
