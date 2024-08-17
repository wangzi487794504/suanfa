package hash;

import java.util.HashSet;

/**
 * ClassName:Anagram
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/7/30 20:40
 * @Version 1.0
 */
public class Anagram {
    public boolean isAnagram(String s, String t) {
        int[] mark=new int[26];
        for (int i = 0; i < s.length(); i++) {
            mark[s.charAt(i)-'a']+=1;
        }
        for (int i = 0; i < t.length(); i++) {
            mark[t.charAt(i)-'a']-=1;
        }
        for (int i : mark) {
            if (i!=0){
                return false;
            }
        }
        return true;
    }
}
