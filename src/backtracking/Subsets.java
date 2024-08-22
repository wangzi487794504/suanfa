package backtracking;

import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName:Subsets
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/19 20:35
 * @Version 1.0
 */
public class Subsets {

    private List<List<Integer>> listList=new ArrayList<>();
    private List<Integer> temp=new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(0, nums, (LinkedList<Integer>) temp);
        return listList;
    }
    public void backtracking(int startIndex,int[] nums,LinkedList<Integer> temp){
        //循环结束条件
        if (startIndex<=nums.length){
            listList.add(new LinkedList<Integer>(temp));
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
        int[] test=new int[]{1,2,3};
        Subsets subsets=new Subsets();
        List<List<Integer>> subsets1 = subsets.subsets(test);
        subsets1.forEach(a->{
            System.out.println(a);
        });
    }
}
