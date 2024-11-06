import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int candyCnt = sc.nextInt();

        int result = 0;

        for (int a = 1; a <= candyCnt; a++) {
            for (int b = 1; b <= candyCnt - a; b++) {
                for (int c = 1; c <= candyCnt - a - b; c++) {
                    if (a + b + c == candyCnt && a >= b + 2 && c % 2 == 0) {
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
    }

}
