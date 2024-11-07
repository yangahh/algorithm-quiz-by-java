import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] result = bruteForceSearch(input[0], input[1], input[2], input[3], input[4], input[5]);
        System.out.println(result[0] + " " + result[1]);
    }

    static int[] bruteForceSearch(int a, int b, int c, int d, int e, int f) {
        for (int x = -999; x < 1000; x++) {
            for (int y = -999; y < 1000; y++) {
                if ((a * x + b * y == c) && (d * x + e * y == f)) {
                    return new int[] { x, y };
                }
            }
        }
        return new int[] {};
    }

}
