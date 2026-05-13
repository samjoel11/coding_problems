class Solution {
    public int[][] outerTrees(int[][] trees) {
        int left = 0, n = trees.length;

        // find leftmost point
        for (int i = 1; i < n; i++) {
            if (trees[i][0] < trees[left][0] ||
               (trees[i][0] == trees[left][0] && trees[i][1] < trees[left][1])) {
                left = i;
            }
        }

        Set<Integer> hull = new HashSet<>();
        int curr = left;

        while (true) {

            //add current point
            hull.add(curr);

            int next = (curr + 1) % n;
            // points on the same line (collinear points)
            List<Integer> collinearPoints = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (i == curr) continue;

                int dir = cross(trees[curr], trees[next], trees[i]);

                // counter clock wise point
                if (dir < 0) {
                    next = i;
                    // new line creation (no collinear point yet)
                    collinearPoints.clear();
                }
                // collinear case
                else if (dir == 0) {
                    int dist = distance(trees[curr], trees[next], trees[i]);
                    // next point lies in between of (a and i)
                    if (dist < 0) {
                        collinearPoints.add(next);
                        next = i;
                    } 
                    // i point lies in between of (a and next)
                    else {
                        collinearPoints.add(i);
                    }
                }
            }

            // add all collinear points
            for (int idx : collinearPoints) {
                hull.add(idx);
            }

            //after traversing all the borders (wrapping the gift box) we come back to the starting position
            if (next == left) break;

            curr = next;
        }

        int[][] ans = new int[hull.size()][2];
        int i = 0;
        for (int idx : hull) {
            ans[i++] = trees[idx];
        }

        return ans;
    }

    // cross product
    // <0 means counter clockwise (c is on the left of line ab)
    int cross(int[] a, int[] b, int[] c) {
        // (vector AB) Ã (vector AC)
        // A â B â C
        // Left turn âº â CCW (counter clock wise)
        // (x1â,y1â)Ã(x2â,y2â) = x1ây2â â y1âx2â
        return (b[0] - a[0]) * (c[1] - a[1]) -
               (b[1] - a[1]) * (c[0] - a[0]);
    }

    // distance comparison
    int distance(int[] a, int[] b, int[] c) {
        // distanceÂ² = xÂ² + yÂ²
        int d1 = (b[0] - a[0]) * (b[0] - a[0]) +
                 (b[1] - a[1]) * (b[1] - a[1]);

        int d2 = (c[0] - a[0]) * (c[0] - a[0]) +
                 (c[1] - a[1]) * (c[1] - a[1]);

        // <0 means B is closer
        // >0 means C is closer
        return d1 - d2;
    }
}