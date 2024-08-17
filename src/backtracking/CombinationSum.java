package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * ClassName:CombinationSum
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/7/18 8:45
 * @Version 1.0
 */
public class CombinationSum {
    public static List<List<Integer>> results=new LinkedList<>();
    public static LinkedList<Integer> path=new LinkedList<>();
    public static List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(n,k,0,1);
        return results;
    }
    /*
    todo 第一步：尝试确定参数
     需要传入和sum，个数k，总数n，从哪个数开始遍历
     */
    public static void backTracking(int n,int k,int sum,int startIndex){
        //todo 确定终止条件  如果path.size==k，就终止
        // todo 剪枝处理1：如果和大于要求的sum，直接退出就行
        if (sum>n){
            return;
        }
        if (path.size()==k){
            if (sum==n){
                LinkedList<Integer> temp = new LinkedList<>();
                path.forEach(a->{
                    temp.push(a);
                });
                results.add(temp);
                System.out.println("result"+results);
            }
            return;
        }
        //todo 确定单体循环
        //todo 进行剪枝处理2
        for (int i = startIndex; i <= n-(k-path.size())+1; i++) {
            path.push(i);
            sum=sum+i;
            backTracking(n,k,sum, i+1);
            Integer pop = path.pop();
            // todo 回溯时sum还要减去i
            sum=sum-i;
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum3(2, 18);
    }
}
