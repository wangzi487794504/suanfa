package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName:SubsetsWithDup
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/19 21:31
 * @Version 1.0
 */
public class SubsetsWithDup {
    private List<List<Integer>> listList=new ArrayList<>();
    private List<Integer> temp=new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(0,nums, (LinkedList<Integer>) temp);
        return listList;
    }
    public void backtracking(int startIndex,int[] nums,LinkedList<Integer> temp){
        //循环结束条件
        if (startIndex<=nums.length){
            listList.add(new LinkedList<Integer>(temp));
//            if (startIndex>0 && startIndex!=nums.length && nums[startIndex-1]==nums[startIndex]){
//                startIndex=startIndex+1;
//            }
        }
        else {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            temp.add(nums[i]);
            backtracking(i+1, nums,new LinkedList<>(temp));
            //回溯
            temp.remove(temp.size()-1);


        }
    }
    public static void main(String[] args) {
        int[] test=new int[]{5,5,5,5,5};
        SubsetsWithDup subsets=new SubsetsWithDup();
        List<List<Integer>> subsets1 = subsets.subsetsWithDup(test);
        subsets1.forEach(a->{
            System.out.println(a);
        });
    }
}
