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
        String data = br.readLine();

        Stack<Character> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();
                if (data.charAt(i - 1) == '(') {
                    result = result + stack.size();
                } else {
                    result++;
                }
            }
        }

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

}
