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

}
