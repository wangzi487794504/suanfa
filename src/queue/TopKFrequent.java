package queue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ClassName:TopKFrequent
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/7 11:25
 * @Version 1.0
 */
public class TopKFrequent {
    //用栈，相等就加一
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap=new HashMap();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)+1 );
        }
        Queue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });

        hashMap.forEach((a,b)->{
            System.out.println(a);
            queue.add(new int[]{a,b});
        });
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) { //依次从队头弹出k个,就是出现频率前k高的元素
            ans[i] = queue.poll()[0];
        }
        return ans;
    }
}
