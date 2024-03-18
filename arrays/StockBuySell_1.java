package arrays;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class StockBuySell_1 {
    //
    public static void main(String[] args) {
        int[] arr={7,1,5,3,6,4};
        int profit=maxProfit(arr);
        System.out.println("Profit is :"+ profit);
    }
    public static int maxProfit(int[] prices) {
        int profit=0;
        int minPrice=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            minPrice = Math.min(minPrice, prices[i]);
            profit = Math.max(profit, prices[i] - minPrice);

        }
        return profit;
    }

}
