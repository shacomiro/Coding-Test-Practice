import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Lessons120585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int h = Integer.parseInt(br.readLine());

        bw.write(new Solution().solution(arr, h));
        bw.flush();
        bw.close();
    }

    static class Solution {
        public int solution(int[] array, int height) {
            int count = 0;

            for (int a : array) {
                count += (a > height) ? 1 : 0;
            }

            return count;
        }
    }
}
