package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName:Permute
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/21 17:16
 * @Version 1.0
 */
public class Permute {
    private List<List<Integer>> listList=new ArrayList<>();
    private List<Integer> temp=new LinkedList<>();
    HashSet<Integer> hashSet=new HashSet<>();
    public List<List<Integer>> permute(int[] nums) {
        backtracking( nums, (LinkedList<Integer>) temp,hashSet);
        return listList;
    }
    public void backtracking(int[] nums,LinkedList<Integer> temp,HashSet hashSet){
        System.out.println("第"+hashSet);
        //循环结束条件
        if (temp.size()==nums.length){
            listList.add(new LinkedList<Integer>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!hashSet.isEmpty() && hashSet.contains(nums[i])){
                continue;
            }
            hashSet.add(nums[i]);
            temp.add(nums[i]);
            backtracking( nums,new LinkedList<>(temp),hashSet);
            //回溯
            hashSet.remove(nums[i]);
            temp.remove(temp.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] test=new int[]{1,2,2,3};
        Permute subsets=new Permute();
        List<List<Integer>> subsets1 = subsets.permute(test);
        subsets1.forEach(a->{
            System.out.println(a);
        });
    }
}
