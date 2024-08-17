package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * ClassName:IpAddresses
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/13 10:46
 * @Version 1.0
 */
public class IpAddresses {
    private List<String> list=new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return list;
        }
        backtracking(0, s,0);
        return list;
    }
    //确定参数
    void backtracking(int startIndex,String s,int time){
        //终止条件
        if (time==3){
            if (isValidIP(startIndex, s, s.length()-1)){
                list.add(s);
            }
            return;
        }
        //单个循环体
        for (int i = startIndex; i < s.length(); i++) {
            if (isValidIP(startIndex,s,i)){
                //插入符号
                s=s.substring(0,i+1)+'.'+s.substring(i+1, s.length());
                time++;
                //time++
                //进入到下一次，因为插入一个字符了，所以需要加2
                backtracking(i+2, s, time);
                //回溯
                s = s.substring(0, i + 1) + s.substring(i + 2);// 回溯删掉逗点
                time--;
            }
            else {
                break;
            }

        }

    }

    private boolean isValidIP(int start, String s, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;

    }

}
