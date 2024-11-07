import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Solution45Test {


    public static Stream<Arguments> cases() {
        return Stream.of(
                //len 4
                //2 -1 + 3 +1 -1 +1 -1
                Arguments.of(new int[]{2, 3, 1, 1, 4}, 2),
                Arguments.of(new int[]{2, 3, 0, 1, 4}, 2),

                Arguments.of(new int[]{1, 1, 1, 1}, 3),
                Arguments.of(new int[]{2, 0, 2, 0, 1}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("cases")
    void test(int[] input, int expected) {
        Assertions.assertEquals(expected, jump(input));
    }

    public int jump2(int[] nums) {
        int sum = 0;
        int lastIndex = nums.length - 1;
        for (int i = 0; i < lastIndex; i++) {
            sum += nums[i];
            if (sum >= lastIndex) return i;
//            sum--;
        }
        return 0;
    }

    public int jump1(int[] nums, int index) {
        for (int i = 0; i < nums[index]; i++) {
            if (index + nums[i] > nums.length) return 1;
            return 1 + jump(nums, index + i);
        }
        return 0;
    }

    //DFS
    public int jump3(int[] nums) {
        return jump(nums, nums.length - 1);
    }

    public int jump(int[] nums, int index) {
        for (int i = 0; i <= index - 1; i++) {
            if (nums[i] >= index - i) {
                return jump(nums, i) + 1;
            }
        }
        return 0;
    }

    //BFS
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;

        int jumps = 0;             // Count of jumps
        int farthest = 0;           // Farthest point reachable in the current jump
        int currentEnd = 0;         // End of the current jump series

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            // When we reach the end of the current level, increase the jump count
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // If we've already reached the end, break out
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }


}
