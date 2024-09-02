import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] array = new int[n];
        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(input2[i]);
        }

        Arrays.sort(array);
        
        int start = 0;
        int end = array[n - 1];

        int maxHeight = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int total = Arrays.stream(array)
                            .map(x -> x - mid)
                            .filter(x -> x > 0)
                            .sum();
            
            if (total >= m) {
                maxHeight = Math.max(maxHeight, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(maxHeight);
    }

}
