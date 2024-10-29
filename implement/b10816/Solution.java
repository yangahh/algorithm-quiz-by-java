import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    static int n;
    static int m;
    // static List<Integer> cards;
    // static List<Integer> targetNums;
    static String[] cards;
    static String[] targetNums;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        setInputData();

        Map<String, Integer> cardsCnt = new HashMap<>();
        for (String card : cards) {
            if (cardsCnt.containsKey(card)) {
                int cnt = cardsCnt.get(card);
                cardsCnt.put(card, cnt + 1);
            } else {
                cardsCnt.put(card, 1);
            }
        }

        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            result[i] = cardsCnt.getOrDefault(targetNums[i], 0);
        }

        print(result);

    }

    static void setInputData() throws IOException {


        n = Integer.parseInt(br.readLine());
        cards = br.readLine().split(" ");
        // cards = Arrays.stream(br.readLine().split(" "))
        // .map(Integer::parseInt)
        // .collect(Collectors.toCollection(ArrayList::new));

        m = Integer.parseInt(br.readLine());

        // targetNums = Arrays.stream(br.readLine().split(" "))
        // .map(Integer::parseInt)
        // .collect(Collectors.toCollection(ArrayList::new));
        targetNums = br.readLine().split(" ");
        br.close();
    }

    static void print(int[] result) throws IOException {

        for (int i = 0; i < m; i++) {
            bw.write(result[i] + " ");
            // if (i != result.size() - 1) {
            // bw.write(" ");
            // }
        }
        bw.flush();
        bw.close();
    }

    public static void main2(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] cards = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        br.close();

        Map<String, Integer> cardCnt = new HashMap<>();
        int[] result = new int[m];

        for (String card : cards) {
            if (cardCnt.containsKey(card)) {
                int cnt = cardCnt.get(card);
                cardCnt.put(card, cnt + 1);
            } else {
                cardCnt.put(card, 1);
            }
        }

        for (int i = 0; i < m; i++) {
            if (cardCnt.containsKey(nums[i])) {
                result[i] = cardCnt.get(nums[i]);
            }
            bw.write(result[i] + " ");
        }
        bw.write("\n");

        bw.flush();
        bw.close();
    }

}
