package backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName:FirstBackTrack
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/7/16 16:49
 * @Version 1.0
 */
public class FirstBackTrack {
    private static List<List<Integer>> result=new LinkedList<>();
    private static LinkedList<Integer> path=new LinkedList<>();
    public static List<List<Integer>> combine(int n, int k) {
        backtracking2(n,k,1);
        return result;
    }
    //确定参数
    public static void backtracking(int n,int k,int startIndex){
        //退出条件
        if (path.size()==k){
            LinkedList temp=new LinkedList();
            path.forEach(a->{
                temp.push(a);
            });
            result.add(temp);
            System.out.println("result"+result);
            return ;
        }
        //单个递归
        for (int i = startIndex; i <=n ; i++) {
            path.push(i);
            System.out.println("path"+path);
            backtracking(n,k,i+1);
            Integer pop = path.pop();
            System.out.println("path2"+path);
        }
    }
    //减枝操作
    //确定参数
    public static void backtracking2(int n,int k,int startIndex){
        //退出条件
        if (path.size()==k){
            LinkedList temp=new LinkedList();
            path.forEach(a->{
                temp.push(a);
            });
            result.add(temp);
            System.out.println("result"+result);
            return ;
        }
        //k-path.size()是还需要多少元素
        //n-(k-path.size())是最少从哪个数开始才能满足要求k
        for (int i = startIndex; i <=n-(k-path.size())+1 ; i++) {
            path.push(i);
            System.out.println("path"+path);
            backtracking2(n,k,i+1);
            Integer pop = path.pop();
            System.out.println("path2"+path);
        }
    }
    @Test
    public void test1(){
        List<List<Integer>> lists = combine(4, 2);
        lists.forEach(list->{
            System.out.println(list);
        });
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = combine(4, 2);

    }
}
