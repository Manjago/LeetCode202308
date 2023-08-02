import java.util.ArrayList;
import java.util.List;

// 2023008-02 46. Permutations https://leetcode.com/problems/permutations/
public class LeetCode00046 {
    /*
{1 2 3 }
1 {2 3}
1 2 3
1 3 2
2 {1 3}
2 1 3
2 3 2
3 {1 2}
3 1 2
3 2 1
*/
    public List<List<Integer>> permute(int[] nums) {

        final List<List<Integer>> result = new ArrayList<>();

        if (nums.length == 1) {
            final List<Integer> item = new ArrayList<>();
            item.add(nums[0]);
            result.add(item);
            return result;
        }

        final int[] nextNums = new int[nums.length - 1];
        for (int i = 0; i < nums.length; ++i) {
            int index = 0;
            for (int j = 0; j < nums.length; ++j) {
                if (i != j) {
                    nextNums[index++] = nums[j];
                }
            }
            final List<List<Integer>> recResults = permute(nextNums);
            for (int k = 0; k < recResults.size(); ++k) {
                final List<Integer> resResult = recResults.get(k);
                final List<Integer> item = new ArrayList<>();
                item.add(nums[i]);
                item.addAll(resResult);
                result.add(item);
            }
        }
        return result;
    }
}
