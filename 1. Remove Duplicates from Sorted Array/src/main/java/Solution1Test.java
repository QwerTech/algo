import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Solution1Test {

    public static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, new int[]{0, 1, 2, 3, 4})
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

    static int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k]) {
                k++;
                nums[k] = nums[i];
            }
        }
        return k + 1;
    }
}
