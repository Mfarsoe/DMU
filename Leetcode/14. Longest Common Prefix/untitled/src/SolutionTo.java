import java.util.Arrays;

public class SolutionTo {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length-1];
        int minLength = Math.min(first.length(), last.length());

        int index = 0;
        while (index < minLength && first.charAt(index) == last.charAt(index)) {
           index++;
        }
        return first.substring(0, index);
    }
}
