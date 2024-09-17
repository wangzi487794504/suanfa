package graph;

import java.util.*;

/**
 * ClassName:WideDfs
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/14 13:41
 * @Version 1.0
 */
public class WideDfs {
    static List<List<Integer>> lists;
    //实现广度优先搜索
    static boolean[] isValid;
    static List<Integer> path=new ArrayList<>();
    static void wfs(int start,int target){
        Queue<Integer> queue=new ArrayDeque<>();
        isValid[start]= true;
        if (start==target){
            return;
        }
        queue.add(start);
        while (queue.isEmpty()==false){
            Integer temp = queue.poll();
            path.add(temp);
            //获取节点
            Iterator<Integer> iterator = lists.get(temp).stream().iterator();
            while (iterator.hasNext()){
                Integer value = iterator.next();
                if (!isValid[value]){
                    isValid[value]=true;
                    queue.add(value);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //边的个数
        int m = scanner.nextInt();
        //节点个数
        int n = scanner.nextInt();
        lists=new ArrayList<>(n+1);
        isValid=new boolean[n+1];
        for (int i = 0; i < n+1; i++) {
            lists.add(new ArrayList<>());
        }
        //邻接表
        while (m-->0){
            int node1= scanner.nextInt();
            int node2= scanner.nextInt();
            lists.get(node1).add(node2);
        }
        wfs(1,n);
        path.forEach(a->{
            System.out.println(a);
        });
    }
}
