import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Solution27Test {

    public static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 2, 3}, 3, new int[]{2, 2}),
                Arguments.of(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, new int[]{0, 1, 4, 0, 3}),
                Arguments.of(new int[]{1}, 1, new int[]{})
        );
    }

    @ParameterizedTest
    @MethodSource("cases")
    void test(int[] nums, int val, int[] expectedNums) {
        int k = removeElement(nums, val);

        Assertions.assertEquals(expectedNums.length, k);
        int[] dest = new int[k];
        System.arraycopy(nums, 0, dest, 0, k);
        Assertions.assertArrayEquals(expectedNums, dest);
    }

    public int removeElement(int[] nums, int val) {
        int last = nums.length - 1;
        int i = 0;
        while (i <= last) {
            if (nums[last] == val) {
                last--;
                continue;
            }
            if (nums[i] == val) {
                nums[i] = nums[last];
                nums[last] = val;
                last--;
            }
            i++;
        }
        return last + 1;
    }
}
