import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Lessons120819 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Arrays.toString(new Solution().solution(Integer.parseInt(br.readLine()))));
        bw.flush();
    }

    static class Solution {
        public int[] solution(int money) {
            return new int[] { money / 5500, money % 5500 };
        }
    }
}
