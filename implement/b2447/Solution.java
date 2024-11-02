package b2447;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        String[] result = drawStars(n);

        print(result);

    }

    static String[] drawStars(int n) {
        if (n == 1) {
            return new String[] { "*" };
        }

        String[] stars = drawStars(n / 3);
        String[] result = new String[n];

        for (int i = 0; i < stars.length; i++) {
            result[i] = stars[i].repeat(3);
        }

        int idxPoint = n / 3;
        for (int i = 0; i < stars.length; i++) {
            result[idxPoint + i] = stars[i] + " ".repeat(n / 3) + stars[i];
        }

        idxPoint = n / 3 * 2;
        for (int i = 0; i < stars.length; i++) {
            result[idxPoint + i] = stars[i].repeat(3);
        }
        return result;
    }

    static void print(String[] result) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < result.length; i++) {
            bw.write(result[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

}
