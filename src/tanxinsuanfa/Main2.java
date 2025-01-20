package tanxinsuanfa;

import graph.Dfs;
import tree.TreeNode;

import java.util.*;

/**
 * ClassName:Main
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/21 16:25
 * @Version 1.0
 */
public class Main2 {
    static class TreeNode{
        int color;
        List<TreeNode> children;
        TreeNode(int color){
            this.color=color;
            this.children=new ArrayList<>();
        }
    }
    static  int maxSum=0;

    private static Map<Integer,Integer> dfs(TreeNode node,boolean[] visited) {
        //颜色数量小于1000
        if (node==null){
            return new HashMap<>();
        }
        visited[node.color]=true;
        Map<Integer,Integer> colorCount=new HashMap<>();
        colorCount.put(node.color, 1);
        for (TreeNode child : node.children) {
            if (!visited[child.color]){
               Map<Integer,Integer> subTreeCount=dfs(child, visited);
                for (Map.Entry<Integer, Integer> entry : subTreeCount.entrySet()) {
                    colorCount.put(entry.getKey(), colorCount.getOrDefault(entry.getKey(), 0)+entry.getValue());
                }
            }
        }
        int maxCount=0;
        for (Integer value : colorCount.values()) {
            if (value>maxCount){
                maxCount=value;
            }
        }
        int xorSum=0;
        for (Map.Entry<Integer, Integer> entry : colorCount.entrySet()) {
            if (entry.getValue()!=maxCount){
                xorSum ^= entry.getKey();;
            }
        }
        maxSum= Math.max(maxSum, xorSum);
        return colorCount;
    }

    public static void main(String[] args) {
        //输入
        Scanner scanner = new Scanner(System.in);
        //汽车数量
        int n= scanner.nextInt();
        int[] colors=new int[n+1];
        for (int i = 1; i <= n; i++) {
            colors[i]= scanner.nextInt();
        }
        Map<Integer,TreeNode> nodes=new HashMap<>();
        for (int i = 1; i <= n; i++) {
            nodes.put(i, new TreeNode(colors[i]));
        }
        for (int i = 1; i < n-1 ; i++) {
           int u= scanner.nextInt();
           int v= scanner.nextInt();
           nodes.get(u).children.add(nodes.get(v));
           nodes.get(v).children.add(nodes.get(u));
        }
        boolean[] visited=new boolean[n+1];
        dfs(nodes.get(1),visited);
        System.out.println(maxSum);
    }

}
