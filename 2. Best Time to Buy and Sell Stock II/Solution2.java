public class Solution2 {
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int expected = 7;
        int k = new Solution2().maxProfit(prices);
        assert expected == k;
        int[] prices1 = new int[]{1,2,3,4,5};
        int expected1 = 4;
        int k1 = new Solution2().maxProfit(prices1);
        if(expected1 != k1){
        };
    }

    //find max and min, then split the array into subarrays, repeat
    // calculate profits all to all, find the combination with max
    // keep it while it's growing

    public int maxProfit(int[] prices) {
        int bought = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                profit += prices[i - 1] - bought;
                bought = prices[i];
            }
        }
        return profit;
    }
}
