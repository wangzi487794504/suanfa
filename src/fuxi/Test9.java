package fuxi;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * ClassName:Test9
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/10/12 10:00
 * @Version 1.0
 */
public class Test9 {
    public int attendmeetings (ArrayList<ArrayList<Integer>> meetings) {
        // write code here
        //使用贪心的思想试试，每次选择结束最早的哪个
        //先排序
        int[][] array=new int[meetings.size()][2];
        System.out.println(meetings);
        System.out.println(meetings.get(1).get(0));
        System.out.println("meijin");
        for (int i = 0; i < meetings.size(); i++) {
            System.out.println(meetings.get(i).get(0));
            array[i][0]=meetings.get(i).get(0);
            array[i][1]=meetings.get(i).get(1);
        }
        Arrays.sort(array,(a, b)-> a[1]-b[1]);

        int result=0;
        //记录上一个会议的结束时间，比1小就行
        int lastEnd=0;
        for (int[] temp : array) {
            if (temp[0]>=lastEnd){
                result++;
                lastEnd=temp[1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(1);
        temp.add(2);
        ArrayList<Integer> temp2=new ArrayList<>();
        temp2.add(2);
        temp2.add(3);
        ArrayList<Integer> temp3=new ArrayList<>();
        temp3.add(4);
        temp3.add(5);
        lists.add(temp);
        lists.add(temp2);
        lists.add(temp3);
//        System.out.println((lists.get(1)).get(0));
        new Test9().attendmeetings(lists);
    }
}
