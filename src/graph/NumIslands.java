package graph;

import java.util.Scanner;

/**
 * ClassName:NumIslands
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/14 15:19
 * @Version 1.0
 */
public class NumIslands {
    static int[][] graph;
    public int numIslands(char[][] grid) {
        if (grid==null || grid.length==0){
            return 0;
        }
        int m= grid.length;
        int n=grid[0].length;
        int num_islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]=='1'){
                    ++num_islands;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //边数
        int m= scanner.nextInt();
        //节点数
        int n = scanner.nextInt();
        graph=new int[n+1][n+1];
    }
}
