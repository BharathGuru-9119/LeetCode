import java.util.Scanner;

public class PowerOfFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get the number from the user
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        // Check if it's a power of four
        boolean result = isPowerOfFour(n);

        // Show result
        if (result) {
            System.out.println(n + " is a power of four.");
        } else {
            System.out.println(n + " is NOT a power of four.");
        }

        sc.close();
    }

    // Function to check if n is a power of 4
    public static boolean isPowerOfFour(int n) {
        if (n <= 0) return false;  // Negative numbers and zero are not powers of 4

        // Keep dividing by 4 until we can't
        while (n % 4 == 0) {
            n = n / 4;
        }

        // If we end up with 1, it was a power of 4
        return n == 1;
    }
}
