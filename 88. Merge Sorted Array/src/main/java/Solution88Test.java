import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Solution88Test {

    public static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3, new int[]{1, 2, 2, 3, 5, 6}),
                Arguments.of(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3, new int[]{1, 2, 3, 4, 5, 6})
        );
    }

    @ParameterizedTest
    @MethodSource("cases")
    void test(int[] nums1, int m, int[] nums2, int n, int[] expected) {
        new Solution88Test().merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
        Assertions.assertArrayEquals(expected, nums1);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tempArr = new int[m];
        System.arraycopy(nums1, 0, tempArr, 0, m);
        if (n == 0) return;
        int j = 0;
        int y = 0;
        int nums2j;
        int nums1y;
        for (int i = 0; i < m + n; i++) {
            if (y >= m) {
                nums1[i] = nums2[j];
                j++;
                continue;
            }
            if (j >= n) {
                nums1[i] = tempArr[y];
                y++;
                continue;
            }
            nums2j = nums2[j];
            nums1y = tempArr[y];
            if (nums2j < nums1y) {
                nums1[i] = nums2j;
                j++;
            } else {
                nums1[i] = nums1y;
                y++;
            }
        }
    }
}
