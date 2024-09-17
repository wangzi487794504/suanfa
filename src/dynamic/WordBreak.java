package dynamic;

import com.sun.org.apache.regexp.internal.RE;

import java.util.List;

/**
 * ClassName:WordBreak
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/13 21:33
 * @Version 1.0
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int j = 1; j <= s.length(); j++) {
            for (int i = 0; i < j && !dp[j]; i++) {
                String temp = s.substring(i,j);
                dp[j] = dp[i] && wordDict.contains(temp);
            }
        }
        return dp[s.length()];

    }
}
