import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read integer N from standard input
        int N = scanner.nextInt();
        scanner.close();

        // Loop from 1 to 10 to print multiples
        for (int i = 1; i <= 10; i++) {
            int result = N * i;
            // Use println to output each result on a new line
            System.out.println(N + " x " + i + " = " + result);
        }
    }
}
