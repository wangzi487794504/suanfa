package backtracking;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName:FindSubsequences
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/19 22:06
 * @Version 1.0
 */
public class FindSubsequences {
    private List<List<Integer>> listList=new ArrayList<>();
    private List<Integer> temp=new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking( 0,nums, (LinkedList<Integer>) temp);
        return listList;
    }
    public void backtracking(int startIndex,int[] nums,LinkedList<Integer> temp){
        //循环结束条件
            if (temp.size()>=2){
                listList.add(new LinkedList<Integer>(temp));
            }
            //这个是让递归元素递增，这里的拦截是一个递归树竖着方向的筛选

        HashSet<Integer> hs = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            //每个后面的元素都要比前面的大
            if ((temp.isEmpty()  || nums[i]>= temp.get(temp.size()- 1) ) && !(hs.contains(nums[i]))){
                hs.add(nums[i]);
                temp.add(nums[i]);
                backtracking(i+1, nums,new LinkedList<>(temp));
                //回溯
                temp.remove(temp.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        int[] test=new int[]{4,6,7,7};
        FindSubsequences subsets=new FindSubsequences();
        List<List<Integer>> subsets1 = subsets.findSubsequences(test);
        subsets1.forEach(a->{
            System.out.println(a);
        });
    }
}
