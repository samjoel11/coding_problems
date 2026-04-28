#include <iostream>
#include <cstdio>
#include <iomanip>

using namespace std;

int main() {
    int i;
    long l;
    char ch;
    float f;
    double d;

    // Use scanf with appropriate format specifiers
    // %d (int), %ld (long), %c (char), %f (float), %lf (double)
    scanf("%d %ld %c %f %lf", &i, &l, &ch, &f, &d);

    // Print values each on a new line
    // .3f ensures float is correct to 3 decimal places
    // .9lf ensures double is correct to 9 decimal places
    printf("%d\n%ld\n%c\n%.3f\n%.9lf", i, l, ch, f, d);

    return 0;
}
