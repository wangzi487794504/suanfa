package hash;

/**
 * ClassName:CanCon
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/11 9:23
 * @Version 1.0
 */
public class CanCon {
    private int[] chat=new int[26];
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length()<ransomNote.length()){
            return false;
        }
        for (int i = 0; i < magazine.length(); i++) {
            chat[magazine.charAt(i)-'a']+=1;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            chat[ransomNote.charAt(i)-'a']-=1;
        }
        for (int i : chat) {
            if (i<0){
                return false;
            }
        }
        return true;
    }
}
