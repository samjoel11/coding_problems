#include <stdio.h>
#include <stdlib.h> // Required for abs() function

void update(int *a, int *b) {
    // Store original values temporarily
    int original_a = *a;
    int original_b = *b;

    // Update a to be the sum
    *a = original_a + original_b;

    // Update b to be the absolute difference
    *b = abs(original_a - original_b);
}

int main() {
    int a, b;
    int *pa = &a, *pb = &b;
    
    // Read input and call function
    scanf("%d %d", &a, &b);
    update(pa, pb);
    printf("%d\n%d", a, b);

    return 0;
}
