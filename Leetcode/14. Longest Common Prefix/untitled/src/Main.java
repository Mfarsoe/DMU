public class Main {
    public static void main(String[] args) {
        String[] f = {"flower","flow","flight"};
        Solution s = new Solution();
        SolutionTo ss = new SolutionTo();

        System.out.println(s.longestCommonPrefix(f));
        System.out.println(ss.longestCommonPrefix(f));
    }
}
