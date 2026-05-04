import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Lessons120822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.valueOf(new Solution().solution(br.readLine())));
        bw.flush();
        bw.close();
    }

    static class Solution {
        public String solution(String my_string) {
            return new StringBuilder(my_string).reverse().toString();
        }
    }
}
