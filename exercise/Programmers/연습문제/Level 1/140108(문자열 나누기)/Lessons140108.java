import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Lessons140108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.valueOf(new Solution().solution(br.readLine())));
        bw.flush();
        bw.close();
    }

    static class Solution {
        public int solution(String s) {
            int answer = 0;
            char x = ' ';
            int xCnt = 0;
            int oCnt = 0;

            for (char c : s.toCharArray()) {
                if (xCnt == 0) {
                    x = c;
                    answer++;
                }

                if (x == c) {
                    xCnt++;
                } else {
                    oCnt++;
                }

                if (xCnt == oCnt) {
                    xCnt = 0;
                    oCnt = 0;
                }
            }
            return answer;
        }
    }
}
