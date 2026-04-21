import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Lessons181834 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution().solution(br.readLine()));
        bw.flush();
        bw.close();
    }

    static class Solution {
        public String solution(String myString) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < myString.length(); i++) {
                char c = myString.charAt(i);
                sb.append((c <= 'l') ? 'l' : c);
            }

            return sb.toString();
        }
    }
}
