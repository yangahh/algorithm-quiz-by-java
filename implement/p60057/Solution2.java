package p60057;

public class Solution2 {
    public int solution(String s) {
        int min = s.length();
        int len = s.length() / 2 + 1;

        for (int i = 1; i < len; i++) {
            String before = "";
            int sum = 0;
            int cnt = 1;

            for (int j = 0; j < s.length();) {
                int start = j;
                j = (j + i > s.length()) ? s.length() : j + i; // j + i 가 s의 길이보다 작거나 같으면 j는 i만큼 증가, 아니면 j는 s길이로 지정
                String temp = s.substring(start, j);
                if (temp.equals(before)) {
                    cnt++;
                } else {
                    if (cnt != 1) {
                        sum += (int) Math.log10(cnt) + 1; // 100 -> (int)log100 + 1 = 3자리
                    }
                    cnt = 1;
                    sum += before.length();
                    before = temp;
                }
            }
            sum += before.length();
            if (cnt != 1) {
                sum += (int) Math.log10(cnt) + 1;
            }
            min = (min > sum) ? sum : min;
        }

        return min;
    }
}
