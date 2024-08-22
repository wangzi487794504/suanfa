package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName:SolveNQueens
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/21 20:55
 * @Version 1.0
 */
public class SolveNQueens {
    private List<List<String>> listList=new ArrayList<>();
    private char[][] qiPan;
    public List<List<String>> solveNQueens(int n) {
        qiPan=new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(qiPan[i], '.');
        }
        backtracking(qiPan,0);
        return listList;
    }
    private void backtracking(char[][] qiPan,int rows){
        if (rows== qiPan.length){
            listList.add(Array2List(qiPan));
            return;
        }
        for (int i = 0; i < qiPan.length; i++) {
            if (isValid(rows, i, qiPan.length, qiPan)){
                System.out.println("aaa");
                qiPan[rows][i]='Q';
                backtracking(qiPan, rows+1);
                qiPan[rows][i]='.';
            }
        }
    }
    public List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }
    private boolean isValid(int row, int col, int n, char[][] qiPan){
// 检查列
        for (int i=0; i<row; ++i) { // 相当于剪枝
            if (qiPan[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (qiPan[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (qiPan[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        List<List<String>> lists = new SolveNQueens().solveNQueens(4);
        lists.forEach(a->{
            System.out.println(a);
        });
    }
}
