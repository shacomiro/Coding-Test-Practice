import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Lessons120830 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String
                .valueOf(new Solution().solution(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()))));
        bw.flush();
        bw.close();
    }

    static class Solution {
        public int solution(int n, int k) {
            return (n * 12000) + ((k - (n / 10)) * 2000);
        }
    }
}