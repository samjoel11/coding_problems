class Solution {
    int m, n;
    int[][] memo;

    /**
     * Calculates the minimum initial health required for the knight to reach the bottom-right.
     * @param dungeon 2D grid where negative values are demons and positive are magic orbs.
     * @return The minimum health needed (must be at least 1).
     */
    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length;
        
        // memo[i][j] stores the min health needed to survive from (i, j) to the princess
        memo = new int[m][n];
        return fun(dungeon, 0, 0);
    }

    private int fun(int[][] dungeon, int i, int j) {
        // Base Case: If we move out of bounds, return a very high value 
        // so this path is ignored by the Math.min() check.
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        // Return the cached result if we've already calculated this cell
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        // Base Case: Reached the Princess (bottom-right corner)
        if (i == m - 1 && j == n - 1) {
            // If the cell is positive (orb), we only need 1 HP to enter.
            // If it's negative (demon), we need 1 + the absolute value of the damage.
            memo[i][j] = Math.max(1, 1 - dungeon[i][j]);
            return memo[i][j];
        }

        // Recursive Step: Check the required health from the cell to the right and the cell below
        int right = fun(dungeon, i, j + 1);
        int down = fun(dungeon, i + 1, j);

        // To survive the current cell, we take the minimum health needed for the next step 
        // and subtract the current cell's value (dungeon[i][j]).
        int need = Math.min(right, down) - dungeon[i][j];

        // The knight must always have at least 1 HP. If 'need' is 0 or negative 
        // (because the current cell provides high health), we reset it to 1.
        memo[i][j] = Math.max(1, need);
        
        return memo[i][j];
    }
}