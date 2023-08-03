import java.util.ArrayList;
import java.util.List;

// 2023-08-03 17. Letter Combinations of a Phone Number https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
public class LeetCode00017 {

    public static void main(String[] args) {
        System.out.println(new LeetCode00017().letterCombinations("23333"));
    }

    private final char[][] dict = new char[][] {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };


    public List<String> letterCombinations(String digits) {

        final List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }

        final String nextString = digits.substring(1);
        final List<String> deepResults = letterCombinations(nextString);

        final int indexMe = digits.charAt(0) - '2';
        for(int i = 0; i < dict[indexMe].length; ++i) {
            final char firstChar = dict[indexMe][i];

            if (nextString.isEmpty()) {
                result.add("" + firstChar);
            } else {
                for(String deepResult : deepResults) {
                    result.add(firstChar + deepResult);
                }
            }
        }

        return result;
    }


}
