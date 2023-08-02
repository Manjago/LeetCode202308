import java.util.ArrayList;
import java.util.List;

// 2023008-02 46. Permutations https://leetcode.com/problems/permutations/ by ChatGPT
public class LeetCode00046_1 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }

    private void permuteHelper(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                current.add(nums[i]);
                used[i] = true;
                permuteHelper(nums, used, current, result);
                used[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }
}
