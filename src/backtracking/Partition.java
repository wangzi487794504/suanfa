package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * ClassName:Partition
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/11 17:46
 * @Version 1.0
 */
public class Partition {
    private List<List<String>> lists=new LinkedList<>();
    private List<String> path=new LinkedList<>();
    public List<List<String>> partition(String s) {
        backtracking(s,0);
        return lists;
    }
    void backtracking(String s,int startIndex){
        if (s.length()==startIndex){
            lists.add(new LinkedList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String hui=s.substring(startIndex, i+1);
            if (isHuiWen(hui)){
                path.add(hui);
                backtracking(s, startIndex+1);
                path.remove(path.size()-1);
            }
        }
    }
    //判断是不是回文字符串
    public Boolean isHuiWen(String s){
        if (s.length()==1){
            return true;
        }
        int left=0;
        int right=s.length()-1;
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> results = new Partition().partition("aab");
        for (List<String> result : results) {
            System.out.println(result);
        }
    }
}
