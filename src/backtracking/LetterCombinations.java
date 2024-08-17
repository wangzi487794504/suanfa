package backtracking;

import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName:LetterCombinations
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/7/18 10:04
 * @Version 1.0
 */
public class LetterCombinations {
    //首先定义一个数组，进行mapping
    public static String[] mapperString=new String[]{"","","abc",
    "def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private static List<String> result=new LinkedList<>();
    private static StringBuilder path=new StringBuilder();
    public static List<String> letterCombinations(String digits) {
        //先分割
        if (digits == null || digits.length() == 0) {
            return result;
        };
        backTracking(0, digits);
        //bytes的长度就是k
        return result;
    }
    // todo 确定参数： k--树深度
    public static void backTracking(int startIndex,String digits){
        // todo 确定终止条件
        if (path.length()==digits.getBytes().length){
            result.add(path.toString());
//            System.out.println(result);
            return;
        }
        //确定递归体
        int length=digits.getBytes()[startIndex]-'0';
        for (int i = 0; i < mapperString[length].getBytes().length; i++) {
//            System.out.println(mapperString[length].charAt(i));
                path.append(mapperString[length].charAt(i));
                backTracking(startIndex+1,digits);
                path.deleteCharAt(path.length()-1);
        }
    }
    public static void main(String[] args) {
        letterCombinations("23");
//        System.out.println("aa".substring(0,1));
//        System.out.println(String.valueOf('a'));
    }
}
