package backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName:combinationSum2
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/7/18 14:14
 * @Version 1.0
 */
public class CombinationSum2 {
    public static List<List<Integer>> results=new LinkedList<>();
    public static LinkedList<Integer> path=new LinkedList<>();
    private static int[] used;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        used=new int[candidates.length];
        Arrays.sort(candidates);
        backTracking(candidates,0,0,target);
        return results;
    }
    public static void backTracking(int[] candidates,int sum,int startIndex,int target){
        //终止条件
        if (sum==target){
            results.add(new LinkedList<>(path));
            return;
        }
        if (sum>target) {
            return;
        }
        //单个循环
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum+candidates[i]>target) {
                break;
            }
            if (i>0 && candidates[i]==candidates[i-1] && used[i-1]==0){
                continue;
            }
            path.push(candidates[i]);
            sum=sum+candidates[i];
            used[i]=1;
            backTracking(candidates, sum, i+1, target);
            path.pop();
            sum=sum-candidates[i];
            used[i]=0;
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum(new int[]{10,1,2,7,6,1,5}, 8);
        lists.forEach(value->{
            System.out.println(value);
        });
    }
}
