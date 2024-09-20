package test;

import java.util.Scanner;

/**
 * ClassName:Test1
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/19 0:04
 * @Version 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); // 读取输入字符串
        String result = removeDuplicates(input);
        System.out.println(result); // 输出结果
    }

    /**
     * 删除字符串中所有相邻且相同的字符对
     * @param s 输入的字符串
     * @return 删除后的字符串
     */
    public static String removeDuplicates(String s) {
        // 使用StringBuilder作为栈的替代
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) { // 逐字符遍历输入字符串
            // 检查StringBuilder是否为空，以及最后一个字符是否与当前字符相同
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
                sb.deleteCharAt(sb.length() - 1); // 删除最后一个字符（相同字符对被删除）
            } else {
                sb.append(c); // 添加当前字符到StringBuilder
            }
        }
        return sb.toString(); // 返回结果字符串
    }
}
