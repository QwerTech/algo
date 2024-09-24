import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Solution169Test {

    public static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 3}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("cases")
    void test(int[] input, int expected) {
        Assertions.assertEquals(expected, majorityElement(input));
    }

    public int majorityElement(int[] nums) {
        int counter = 0;
        int candidate = 0;
        for (int num : nums) {
            if (counter == 0) {
                candidate = num;
            }
            if (num == candidate) {
                counter++;
            } else {
                counter--;
            }
        }
        return candidate;
    }
}
