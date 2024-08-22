package backtracking;

import java.util.*;

/**
 * ClassName:Permute
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/21 17:16
 * @Version 1.0
 */
public class PermuteUnique {
    private List<List<Integer>> listList=new ArrayList<>();
    private List<Integer> temp=new LinkedList<>();
    HashSet<Integer> hashSet=new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
            if (i>0 && nums[i]==nums[i-1] && !hashSet.contains(i-1)){
                continue;
            }
            if (!hashSet.isEmpty() && hashSet.contains(i)){
                continue;
            }
            hashSet.add(i);
            temp.add(nums[i]);
            backtracking( nums,new LinkedList<>(temp),hashSet);
            //回溯
            hashSet.remove(i);
            temp.remove(temp.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] test=new int[]{1,1,2};
        PermuteUnique subsets=new PermuteUnique();
        List<List<Integer>> subsets1 = subsets.permuteUnique(test);
        subsets1.forEach(a->{
            System.out.println(a);
        });
    }
}
