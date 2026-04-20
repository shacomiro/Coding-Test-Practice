import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Lessons147355 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.valueOf(new Solution().solution(br.readLine(), br.readLine())));
        bw.flush();
        bw.close();
    }

    static class Solution {
        public int solution(String t, String p) {
            int count = 0;
            int len = p.length();
            long numP = Long.parseLong(p);

            for (int i = 0; i <= t.length() - len; i++) {
                long numT = Long.parseLong(t.substring(i, i + len));
                if (numT <= numP) {
                    count++;
                }
            }

            return count;
        }
    }
}
