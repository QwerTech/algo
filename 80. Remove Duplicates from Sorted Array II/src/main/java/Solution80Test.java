import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Solution80Test {

    public static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1, 2, 2, 3}, new int[]{1, 1, 2, 2, 3}),
                Arguments.of(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 3, 3}),
                Arguments.of(new int[]{1, 1, 1}, new int[]{1, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("cases")
    void test(int[] nums, int[] expectedNums) {
        int k = removeDuplicates(nums);

        System.out.println(Arrays.toString(nums));
        Assertions.assertEquals(expectedNums.length, k);
        int[] dest = new int[k];
        System.arraycopy(nums, 0, dest, 0, k);
        Assertions.assertArrayEquals(expectedNums, dest);
    }

    public int removeDuplicates(int[] nums) {
        int last = nums.length - 1;
        int i = 0;
        int duplicates = 0;
        int prev = Integer.MIN_VALUE;
        while (i <= last) {
            if (nums[i] == prev) {
                duplicates++;
                if (duplicates >= 2) {
                    System.arraycopy(nums, i + 1, nums, i, last - i);
                    last--;
                    i--;
                }
            } else {
                duplicates = 0;
            }
            prev = nums[i];
            i++;
        }
        return last + 1;
    }
}
