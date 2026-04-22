import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Lessons134240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution().solution(arr));
        bw.flush();
        bw.close();
    }

    static class Solution {
        public String solution(int[] food) {
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i < food.length; i++) {
                for (int j = 0; j < (food[i] / 2) * 2; j++) {
                    sb.insert(sb.length() / 2, i);
                }
            }
            sb.insert(sb.length() / 2, 0);

            return sb.toString();
        }
    }
}
