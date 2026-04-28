#include <stdio.h>

int main() {
    char ch;
    char s[100];
    char sen[100];

    // Read a single character
    scanf("%c", &ch);
    
    // Read a single word (stops at the first space)
    // The \n inside scanf helps consume the newline left by the previous input
    scanf("%s\n", s);
    
    // Read the entire line (sentence) including spaces
    // %[^\n] reads everything until it hits a newline
    // %*c reads and discards the final newline character
    scanf("%[^\n]%*c", sen);

    // Print results
    printf("%c\n", ch);
    printf("%s\n", s);
    printf("%s\n", sen);

    return 0;
}
