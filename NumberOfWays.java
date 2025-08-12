import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberOfWays {
    public int numberOfWays(int n, int x) {
        final int MOD = 1_000_000_007;

        // 1) Precompute powers base^x while <= n
        List<Integer> powers = new ArrayList<>();
        for (int base = 1; ; base++) {
            long p = 1;
            for (int i = 0; i < x; i++) {
                p *= base;
                if (p > n) break;
            }
            if (p > n) break;
            powers.add((int) p);
        }

        // 2) dp[s] = number of ways to form sum s using processed powers (each used at most once)
        int[] dp = new int[n + 1];
        dp[0] = 1; // one way to make 0: pick nothing

        // 3) Update dp in reverse order to avoid reusing the same power
        for (int p : powers) {
            for (int s = n; s >= p; s--) {
                int sum = dp[s] + dp[s - p];
                if (sum >= MOD) sum -= MOD;
                dp[s] = sum;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NumberOfWays sol = new NumberOfWays(); // ✅ fixed typo here

        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.print("Enter x: ");
        int x = sc.nextInt();

        int result = sol.numberOfWays(n, x);
        System.out.println("Number of ways: " + result);
    }
}
