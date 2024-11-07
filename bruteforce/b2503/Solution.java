import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine());
        ArrayList<int[]> hints = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            hints.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        br.close();

        int result = 0;

        for (int x = 123; x <= 987; x++) {
            String strX = String.valueOf(x);

            if (strX.charAt(0) == '0' || strX.charAt(1) == '0' || strX.charAt(2) == '0') {
                continue;
            }
            if (strX.charAt(0) == strX.charAt(1)
                    || strX.charAt(1) == strX.charAt(2)
                    || strX.charAt(2) == strX.charAt(0)) {
                continue;
            }

            int passCnt = 0;
            for (int[] hint : hints) {
                int num = hint[0];
                int strike = hint[1];
                int ball = hint[2];

                String strNum = String.valueOf(num);
                int strikeCnt = 0;
                int ballCnt = 0;
                for (int i = 0; i < 3; i++) {
                    if (strX.contains(String.valueOf(strNum.charAt(i)))) {
                        if (strX.charAt(i) == strNum.charAt(i)) {
                            strikeCnt++;
                        } else {
                            ballCnt++;
                        }
                    }
                }
                if (strikeCnt == strike && ballCnt == ball) {
                    passCnt++;
                }
            }

            if (passCnt == n) {
                result++;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

}
