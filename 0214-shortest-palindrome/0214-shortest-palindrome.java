class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        String rev = new StringBuilder(s).reverse().toString();
        String temp = s + "#" + rev;
        int[] lps = new int[temp.length()];
        helper(temp, lps);
        int longestPalPrefix = lps[temp.length() - 1];
        String suffix = s.substring(longestPalPrefix);
        StringBuilder result = new StringBuilder(suffix).reverse();
        return result.toString() + s;
    }
    private void helper(String str, int[] lps) {
        int len = 0;
        int i = 1;
        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}
