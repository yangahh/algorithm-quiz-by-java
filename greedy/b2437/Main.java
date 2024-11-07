import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new
    // OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] weights = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        br.close();

        Arrays.sort(weights);

        int[] avaliableRange = { 0, 0 };

        for (int weight : weights) {
            int curMinLimit = avaliableRange[0];
            int curMaxLimit = avaliableRange[1];

            int newMinLimit = curMinLimit + weight;
            int newMaxLimit = curMaxLimit + weight;

            if (curMaxLimit + 1 < newMinLimit) {
                break;
            }

            avaliableRange[0] = curMinLimit;
            avaliableRange[1] = newMaxLimit;
        }

        // bw.write(avaliableRange[1] + 1 + "\n");
        // bw.flush();
        // bw.close();
        System.out.println(avaliableRange[1] + 1);

    }

}
