package test;

import java.math.BigInteger;
import java.util.*;

/**
 * ClassName:Test
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/10/12 19:16
 * @Version 1.0
 */
public class Test {
    public int[] temperatures (int[] dailyTemperatures) {
        // write code here
        //双指针
        int length=dailyTemperatures.length;
        int[] result=new int[length];
        Stack<Integer> stack=new Stack<>();
        for (int i = length - 1; i >= 0; i--) {
            while (!stack.isEmpty()&& dailyTemperatures[stack.peek()]<=dailyTemperatures[i]){
                stack.pop();
            }
            result[i]=stack.isEmpty()?0:stack.peek()-i;
            stack.push(i);
        }
        return result;
    }
}