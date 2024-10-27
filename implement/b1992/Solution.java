import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] graph;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = s.charAt(j) - '0'; // int로 변환하기 위한 방법
            }
        }
        br.close();

        quadTree(0, 0, n);

        bw.write(result.toString() + "\n");
        bw.flush();
        bw.close();

    }

    static void quadTree(int x, int y, int size) {
        int cur = graph[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (cur != graph[i][j]) {
                    result.append("(");

                    int nextSize = size / 2;
                    quadTree(x, y, nextSize);
                    quadTree(x, y + nextSize, nextSize);
                    quadTree(x + nextSize, y, nextSize);
                    quadTree(x + nextSize, y + nextSize, nextSize);

                    result.append(")");
                    return;
                }
                cur = graph[i][j];
            }
        }

        result.append(cur);

        return;
    }

}
