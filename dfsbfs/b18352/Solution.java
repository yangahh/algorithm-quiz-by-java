import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static int m;
    static int k;
    static int x;
    static LinkedList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        setInputData();
        boolean[] visited = new boolean[n+1];  // 초기값은 false 
        int[] distance = new int[n+1];
        Queue<Integer> q = new LinkedList<>();  // LinkedList는 Deque 와 List 인터페이스를 모두 구현한다.
        q.offer(x);


        while (!q.isEmpty()) {
            int node = q.poll();
            for (int next_node : graph[node]) {
                if (visited[next_node] == false) {
                    visited[next_node] = true;
                    distance[next_node] = distance[node] + 1;
                    q.offer(next_node);
                }
            }
        }

        printResult(distance);

    }

    public static void setInputData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());  // br.readLine().split(" ")을 사용하는 것 보다 빠르다
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new LinkedList[n + 1];  // 노드 번호가 1부터 시작할 때
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int adjacentNode = Integer.parseInt(st.nextToken());
            graph[node].add(adjacentNode);
        }

        br.close(); 
    }

    public static void printResult(int[] distance) {
        boolean isExisting = false;
        for (int i = 1; i < n + 1; i++) {
            if (distance[i] == k & i != x) {
                isExisting = true;
                System.out.println(i);
            }
        }
        if (isExisting == false) {
            System.out.println(-1);
        }

    }
}
