package p60057;

public class Solution {
    public static void main(String[] args) {
        int result = solve("aabbaccc");
        System.out.println(result);

    }

    static int solve(String s) {
        int minLen = s.length();

        for (int i = 1; i < s.length() / 2 + 1; i++) {
            StringBuffer newStr = new StringBuffer();
            int repeatCnt = 1;

            for (int j = 0; j < s.length(); j = j + i) {
                String a;
                if (j + i < s.length()) {
                    a = s.substring(j, j + i);
                } else {
                    a = s.substring(j);
                }

                if (a.length() != i) {
                    if (repeatCnt == 1) {
                        newStr.append(a);
                    } else {
                        newStr.append(String.valueOf(repeatCnt) + a);
                    }
                    repeatCnt = 1;
                    break;
                }

                String b;
                if (j + i + i < s.length() && j != s.length() - 1) {
                    b = s.substring(j + i, j + i + i);
                } else {
                    b = s.substring(j + i);
                }

                if (a.equals(b)) {
                    repeatCnt++;
                } else {
                    if (repeatCnt == 1) {
                        newStr.append(a);
                    } else {
                        newStr.append(String.valueOf(repeatCnt) + a);
                    }
                    repeatCnt = 1;
                }
            }

            if (newStr.length() < minLen) {
                minLen = newStr.length();
            }
        }

        return minLen;
    }

}
