class Solution {
    public String convert(String s, int numRows) {
       if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        int a = 0, b = 1;
        List<Character>[] rows = new ArrayList[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new ArrayList<>();
        }

        for (char c : s.toCharArray()) {
            rows[a].add(c);
            if (a == 0) {
                b = 1;
            } else if (a == numRows - 1) {
                b = -1;
            }
            a += b;
        }

        StringBuilder result = new StringBuilder();
        for (List<Character> row : rows) {
            for (char c : row) {
                result.append(c);
            }
        }

        return result.toString();        
    }
}