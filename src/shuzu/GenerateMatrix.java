package shuzu;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;

/**
 * ClassName:GenerateMatrix
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/4 15:06
 * @Version 1.0
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        //需要定义一个数组
        int[][] matrix=new int[n][n];
        //设计思路，是左开右闭，左边剩余的那个元素让下一个for循环去补充
        //这道题最麻烦的就是边界问题的处理
        int i,j;
        int loop=1;
        int startX=0;
        int startY=0;
        //使其在最后一个成为开区间
        int offset=1;
        int count=1;
        while (loop<=n/2){
            for (j=startY; j < n-offset; j++) {
                matrix[startX][j]=count++;
            }
            for (i=startX; i < n-offset; i++) {
                matrix[i][j]=count++;
            }
            for (; j >startY; j--) {
                matrix[i][j]=count++;
            }
            for (; i >startX; i--) {
                matrix[i][j]=count++;
            }
            startX++;
            startY++;
            loop++;
            offset++;
        }
        if (n%2==1){
            matrix[startX][startY]=count;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] ints = new GenerateMatrix().generateMatrix(3);
        Arrays.stream(ints).forEach(a->{
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }
        });
    }
}
