package tanxinsuanfa;

/**
 * ClassName:MaxProfit
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/22 20:11
 * @Version 1.0
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        //todo 比较今天和下一天哪个价格高，今天高就不买
        boolean flag=false;
        int benifit=0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i]<prices[i+1] && !flag){
                benifit-=prices[i];
                flag=true;
            }
            if (prices[i]>prices[i+1] && flag){
                benifit+=prices[i];
                flag=false;
            }
        }
        if(flag){
            benifit+=prices[prices.length-1];
        }
        return benifit;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
