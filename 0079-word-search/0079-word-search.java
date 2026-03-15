class Solution {
    private static int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private boolean isValid(int i, int j, boolean[][] visited) {
        return (
            i >= 0 && i < visited.length &&
            j >= 0 && j < visited[0].length &&
            !visited[i][j]
        );
    }

    public boolean exist(char[][] board, String word) {
        if (
            board == null ||
            board.length == 0 || board[0].length == 0
        ) return (word.length() == 0);

        if (board.length * board[0].length < word.length()) return false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];        
                int wordIndex = 0; // compare currNode with wordIndex
                // currResult is word if wordIndex == word.len (NO more to compare)
                if (dfs(i, j, board, visited, word, wordIndex))
                    return true;
            }
        }

        return false;
    }

    private boolean dfs(
        int i, int j, // curr node
        char[][] board, boolean[][] visited,
        String word, int wordIndex // curr Result (from prev node)
    ) {
        // Mark visited
        if (visited[i][j]) return false;
        visited[i][j] = true;

        // check curr node, update result
        if (board[i][j] != word.charAt(wordIndex++)) {
            // prune & backtrack
            visited[i][j] = false;
            return false;
        }
        if (wordIndex == word.length()) return true;

        // dfs neighbors
        for (int[] dir: DIRS) {
            int newI = i + dir[0];
            int newJ = j + dir[1];

            if (isValid(newI, newJ, visited)) {
                if (dfs(newI, newJ, board, visited, word, wordIndex))
                    return true;
            }
        }

        // backtrack
        visited[i][j] = false;
        return false;
    }
}