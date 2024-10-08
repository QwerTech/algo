import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Solution55Test {

    public static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 1, 1, 4}, true),
                Arguments.of(new int[]{3, 2, 1, 0, 4}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("cases")
    void test(int[] input, boolean expected) {
        Assertions.assertEquals(expected, canJump(input));
    }

    public boolean canJump(int[] nums) {
        return canJumpTo(nums, nums.length - 1);
    }

    public boolean canJumpTo(int[] nums, int index) {
        if (index == 0) return true;
        for (int i = index-1; i >= 0; i--) {
            if (nums[i] >= index - i) return canJumpTo(nums, i);
        }
        return false;
    }
}
