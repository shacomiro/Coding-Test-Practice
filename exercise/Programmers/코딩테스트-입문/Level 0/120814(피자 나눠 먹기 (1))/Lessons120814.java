import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Lessons120814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution().solution(Integer.parseInt(br.readLine())));
        bw.flush();
        bw.close();
    }

    static class Solution {
        public int solution(int n) {
            return n / 7 + (n % 7 == 0 ? 0 : 1);
        }
    }
}
