import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] graph;

    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        quadTree(0, 0, n);
        print();
    }

    static void quadTree(int x, int y, int graphSize) {
        int cur = graph[x][y];

        for (int i = x; i < x + graphSize; i++) {
            for (int j = y; j < y + graphSize; j++) {
                if (cur != graph[i][j]) {
                    int nextSize = graphSize / 2;

                    quadTree(x, y, nextSize);
                    quadTree(x, y + nextSize, nextSize);
                    quadTree(x + nextSize, y, nextSize);
                    quadTree(x + nextSize, y + nextSize, nextSize);
                    return;
                }

                cur = graph[i][j];

            }
        }

        if (cur == 0) {
            white++;
        } else {
            blue++;
        }

        return;
    }

    static void print() throws IOException {
        bw.write(white + "\n");
        bw.write(blue + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
