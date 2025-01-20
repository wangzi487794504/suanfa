package fuxi;

import lianbiao.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ClassName:Test8
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/10/12 9:23
 * @Version 1.0
 */
public class Test8 {
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        //第一步：判断链表是不是为空
        if (pHead==null || k<=0){
            return null;
        }
        //双指针中的快满指针思想，每次移动k个
        ListNode left=pHead;
        ListNode right=pHead;
        //右指针先跑k个
        for (int i = 0; i < k; i++) {
            //不满足有k个的
            if (right==null){
                return null;
            }
            right=right.next;
        }
        //开始找最后k个，一起移动
        while (right!=null){
            left=left.next;
            right=right.next;
        }
        return left;
    }
    public int attendmeetings (ArrayList<ArrayList<Integer>> meetings) {
        // write code here
        //使用贪心的思想试试，每次选择结束最早的哪个
        //先排序
        System.out.println("size="+meetings.size());
        Collections.sort(meetings,(num1,num2)->{
            //比较结束时间的大小
            return num1.get(1)-num2.get(1);
        });


        int result=0;
        //记录上一个会议的结束时间，比1小就行
        int lastEnd=0;
        //一天只能参加一个
        boolean flag=false;
        for (ArrayList<Integer> meeting : meetings) {
            System.out.println(meeting);
            int begin=meeting.get(0);
            int end=meeting.get(1);
            if (begin==end){
                lastEnd=end;
                result++;
//                System.out.println("ccc");
                flag=true;
                continue;

            }
            if (begin==lastEnd && flag==true){
//                System.out.println("cvv");
                continue;
            }
            if (begin>=lastEnd){
                result++;
                lastEnd=end;
                flag=false;
            }
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(2);
        temp.add(3);
        ArrayList<Integer> temp4=new ArrayList<>();
//        temp4.add(2);
//        temp4.add(2);
        ArrayList<Integer> temp2=new ArrayList<>();
        temp2.add(1);
        temp2.add(2);
        ArrayList<Integer> temp3=new ArrayList<>();
        temp3.add(4);
        temp3.add(5);
        lists.add(temp);
        lists.add(temp2);
        lists.add(temp3);
//        lists.add(temp4);

        new Test8().attendmeetings(lists);
    }
}
