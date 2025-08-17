public class BestTimeToBuyStockAndSell {
    public static int max_profit(int prices[]){
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i =0;i<prices.length;i++){
            if(buyPrice < prices[i]){
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(profit , maxProfit);
            }else{
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int prices[] = {10,1,5,6,7,1};
        int maxProfit = max_profit(prices);
        System.out.println(maxProfit);
    }
}
