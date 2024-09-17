package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName:Dfs
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/14 12:18
 * @Version 1.0
 */
public class Dfs {
    //定义邻接矩阵
    static List<List<Integer>> lists;
    static List<List<Integer>> result=new ArrayList<>();
    static List<Integer> path=new ArrayList<>();
    static void backtracking(List<List<Integer>> lists, int node,int target){
        if (node==target){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < lists.get(node).size(); i++) {
            path.add(lists.get(node).get(i));
            backtracking(lists, lists.get(node).get(i), target);
            //移除这个节点
            path.remove(lists.get(node).get(i));
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //节点的个数
        int n = scanner.nextInt();
        //边的个数
        int m = scanner.nextInt();
        lists=new ArrayList<>(n+1);
        for (int i = 0; i < n +1; i++) {
            lists.add(new ArrayList<>());
        }
        //邻接表存储
        while (m-->0){

            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();
            lists.get(node1).add(node2);
        }
        //从1开始遍历
        path.add(1);
        backtracking(lists, 1, n);
        // 输出结果
        if (result.isEmpty()){
            System.out.println(-1);
        }
        for (List<Integer> pa : result) {
            for (int i = 0; i < pa.size() - 1; i++) {
                System.out.print(pa.get(i) + " ");
            }
            System.out.println(pa.get(pa.size() - 1));
        }
    }
}
