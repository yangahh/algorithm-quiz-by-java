import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine().strip());

        for (int i = 0; i < loop; i++) {
            Long n = Long.parseLong(br.readLine().strip());

            for (int j = 2; j < 1000001; j++) {
                if (n % j == 0) {
                    System.out.println("NO");
                    break;
                }

                if (j == 1000000) {
                    System.out.println("YES");
                }
            }
        }
        br.close();
    }

}
