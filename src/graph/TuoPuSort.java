package graph;

import java.util.*;

/**
 * ClassName:TuoPuSort
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/14 14:56
 * @Version 1.0
 */
public class TuoPuSort {
    static List<List<Integer>> lists;
    //需要记录入度
    static int[] degree;
    static Queue<Integer> queue=new ArrayDeque<>();
    static List<Integer> result=new ArrayList<>();
    public static void sort(){
        while (queue.isEmpty()==false){
            Integer temp = queue.poll();
            //保存出队的
            result.add(temp);
            for (Integer value : lists.get(temp)) {
                degree[value]--;
                //度为0的入队
                if (degree[value]==0){
                    queue.add(value);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //边的个数
        int n = scanner.nextInt();
        //节点个数
        int m = scanner.nextInt();
        lists=new ArrayList<>(n);
        degree=new int[n];
        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<>());
        }
        //邻接表
        while (m-->0){
            int node1= scanner.nextInt();
            int node2= scanner.nextInt();
            degree[node2]++;
            lists.get(node1).add(node2);
        }
        //遍历，度为0的入队
        for (int i : degree) {
            if (i==0){
                queue.add(degree[i]);
            }
        }
        sort();
        result.forEach(a->{
            System.out.print(a);
        });
    }
}
