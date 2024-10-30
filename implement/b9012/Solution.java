package b9012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String s = br.readLine();

            Stack<String> stack = new Stack<>();
            boolean isVPS = true;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.add("(");
                } else {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        isVPS = false;
                        break;
                    }
                }
            }

            if (stack.isEmpty() && isVPS) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
            bw.flush();

        }

        bw.close();
        br.close();
    }

}
