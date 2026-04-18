import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Lessons142086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Arrays.toString(new Solution().solution(br.readLine())));
        bw.flush();
        bw.close();
    }

    static class Solution {
        private int[] lastPos = new int[26];

        public Solution() {
            Arrays.fill(lastPos, -1);
        }

        public int[] solution(String s) {
            int[] answer = new int[s.length()];

            for (int i = 0; i < s.length(); i++) {
                int cIdx = s.charAt(i) - 'a';

                answer[i] = (lastPos[cIdx] == -1) ? -1 : i - lastPos[cIdx];
                lastPos[cIdx] = i;
            }

            return answer;
        }
    }
}
