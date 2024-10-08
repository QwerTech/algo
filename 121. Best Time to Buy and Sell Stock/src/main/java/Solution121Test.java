import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Solution121Test {

    public static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 5),
                Arguments.of(new int[]{7, 6, 4, 3, 1}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("cases")
    void test(int[] input, int expected) {
        Assertions.assertEquals(expected, maxProfit(input));
    }

    public int maxProfit(int[] prices) {
        var profit = 0;
        var cheapest = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            if (cheapest > price) {
                cheapest = price;
            }
            int localProfit = price - cheapest;
            if (localProfit > profit) {
                profit = localProfit;
            }
        }
        return profit;
    }
}
