import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lessons135808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(new Solution().solution(k, m, arr)));
        bw.flush();
        bw.close();
    }

    static class Solution {
        public int solution(int k, int m, int[] score) {
            int benefit = 0;

            Arrays.sort(score);
            for (int i = score.length - m; i >= 0; i -= m) {
                benefit += score[i] * m;
            }

            return benefit;
        }
    }
}
