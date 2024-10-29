import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        String[] zeroGroup = s.split("0");
        String[] oneGroup = s.split("1");

        int zeroGroupCnt = 0;
        int oneGroupCnt = 0;

        for (String x : zeroGroup) {
            if (!x.equals("")) {
                zeroGroupCnt++;
            }
        }

        for (String x : oneGroup) {
            if (!x.equals("")) {
                oneGroupCnt++;
            }
        }

        System.out.println(Math.min(zeroGroupCnt, oneGroupCnt));
    }

    public static void main2(String[] args) throws IOException {
        String s = br.readLine();
        br.close();
        int zeroGroupCnt = 0;
        int oneGroupCnt = 0;
        int n = s.length();

        if (s.charAt(0) == '0') {
            zeroGroupCnt++;
        } else {
            oneGroupCnt++;
        }

        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                if (s.charAt(i) == '0') {
                    zeroGroupCnt++;
                } else {
                    oneGroupCnt++;
                }
            }
        }

        System.out.println(Math.min(zeroGroupCnt, oneGroupCnt));
    }

}
