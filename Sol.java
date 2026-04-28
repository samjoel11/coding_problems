import java.io.*;
import java.util.*;
public class Sol {
    public static void main(String[] args) {
        // Create a Scanner object to read from System.in
        Scanner scan = new Scanner(System.in);
        
        // Read three integers sequentially
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        
        // Print each integer on a new line
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        
        // Good practice: close the scanner
        scan.close();
    }
}

    }
}