import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    static int n;
    static int m;
    static List<Integer> cards;
    static List<Integer> targetNums;

    public static void main(String[] args) throws IOException {
        setInputData();

        Map<Integer, Integer> cardsCnt = new HashMap<>();
        for (int card : cards) {
            if (cardsCnt.containsKey(card)) {
                int cnt = cardsCnt.get(card);
                cardsCnt.put(card, cnt + 1);
            } else {
                cardsCnt.put(card, 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int num : targetNums) {
            result.add(cardsCnt.getOrDefault(num, 0));
        }

        print(result);

    }

    static void setInputData() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        cards = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        m = Integer.parseInt(br.readLine());

        targetNums = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
        br.close();
    }

    static void print(List<Integer> result) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < result.size(); i++) {
            bw.write(result.get(i) + " ");
            // if (i != result.size() - 1) {
            // bw.write(" ");
            // }
        }
        bw.flush();
        bw.close();
    }

}
