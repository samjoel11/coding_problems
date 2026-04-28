#include <stdio.h>

/*
 * Function: max_of_four
 * --------------------
 * Accepts four integers and returns the greatest of them.
 */
int max_of_four(int a, int b, int c, int d) {
    int max = a;
    if (b > max) max = b;
    if (c > max) max = c;
    if (d > max) max = d;
    return max;
}

int main() {
    int a, b, c, d;
    // Input is handled automatically in the HackerRank editor
    if (scanf("%d %d %d %d", &a, &b, &c, &d) == 4) {
        int ans = max_of_four(a, b, c, d);
        printf("%d", ans);
    }
    return 0;
}
