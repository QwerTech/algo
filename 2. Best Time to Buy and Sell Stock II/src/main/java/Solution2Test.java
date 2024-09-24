import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Solution2Test {

    public static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 7),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 4),
                Arguments.of(new int[]{7, 6, 4, 3, 1}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("cases")
    void test(int[] input, int expected) {
        Assertions.assertEquals(expected, maxProfit(input));
    }

    public int maxProfit(int[] prices) {
        int bought = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                profit += prices[i - 1] - bought;
                bought = prices[i];
            }
        }
        profit += prices[prices.length - 1] - bought;

        return profit;
    }
}
