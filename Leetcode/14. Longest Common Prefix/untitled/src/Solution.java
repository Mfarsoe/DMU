import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length-1];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < last.length(); i++) {
            try {
                if (first.charAt(i) == last.charAt(i)) {
                    sb.append(first.charAt(i));
                } else {
                    break;
                }
            } catch (Exception e){}
        }
        return "" + sb.toString();
    }
}