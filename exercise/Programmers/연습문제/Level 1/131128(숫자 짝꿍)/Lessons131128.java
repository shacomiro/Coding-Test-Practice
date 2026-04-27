import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Lessons131128 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution().solution(br.readLine(), br.readLine()));
        bw.flush();
        bw.close();
    }

    static class Solution {
        public String solution(String X, String Y) {
            int[] countX = new int[10];
            int[] countY = new int[10];

            for (int i = 0; i < X.length(); i++) {
                countX[X.charAt(i) - '0']++;
            }

            for (int i = 0; i < Y.length(); i++) {
                countY[Y.charAt(i) - '0']++;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 9; i >= 0; i--) {
                int commonCount = Math.min(countX[i], countY[i]);

                for (int j = 0; j < commonCount; j++) {
                    sb.append(i);
                }
            }

            String answer = sb.toString();

            return answer.isEmpty() ? "-1" : (answer.startsWith("0") ? "0" : answer);
        }
    }
}
