package b14503;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;
    static int startX;
    static int startY;
    static int d;
    static int[][] graph;
    static int result;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        setInputData();
        dfs(startX, startY, d);
        System.out.println(result);
    }

    static void setInputData() throws IOException {
        String[] input1 = br.readLine().strip().split(" ");
        n = Integer.parseInt(input1[0]);
        m = Integer.parseInt(input1[1]);

        String[] input2 = br.readLine().strip().split(" ");
        startX = Integer.parseInt(input2[0]);
        startY = Integer.parseInt(input2[1]);

        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().strip().split(" ");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }
        br.close();

    }

    static void dfs(int x, int y, int d) {
        if (graph[x][y] == 0) {
            graph[x][y] = 2;
            result++;
        }

        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && graph[nx][ny] == 0) {
                dfs(nx, ny, d);
                return;
            }
        }

        int nx = x - dx[d];
        int ny = y = dy[d];
        if (nx >= 0 && nx < n && ny >= 0 && ny < m && graph[nx][ny] != 1) {
            dfs(nx, ny, d);
        } else {
            return;
        }
    }

}
