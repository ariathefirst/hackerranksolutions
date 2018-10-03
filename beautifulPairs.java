import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the beautifulPairs function below.
    // 1 map
    static int beautifulPairs(int[] A, int[] B) {

        Map<Integer, Integer> map_A = new HashMap<>();
        for (Integer a : A) {
            if (!map_A.containsKey(a)) {
                map_A.put(a, 1); 
            } else {
                map_A.put(a, map_A.get(a) + 1);
            }
        }
        int res = 0;
        for (Integer b : B) {
            if (map_A.containsKey(b)) {
                if (map_A.get(b) == 1) {
                    map_A.remove(b);
                }
                else {
                    map_A.put(b, map_A.get(b)-1);
                }
                res += 1;
            }
        }
        return (res == A.length) ? res - 1 : res + 1;         
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int AItem = Integer.parseInt(AItems[i]);
            A[i] = AItem;
        }

        int[] B = new int[n];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        int result = beautifulPairs(A, B);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

