import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution21318 {
    private int n;
    private int[] musicSheet;
    private int q;
    private int[][] questions;
    private int[] prefixSum;

    public Solution21318(int n, int[] musicSheet, int q, int[][] questions) {
        this.n = n;
        this.musicSheet = musicSheet;
        this.q = q;
        this.questions = questions;
        this.prefixSum = new int[n + 1];
    }

    public String solve() {
        for(int i = 1; i <= n; i++) {
            prefixSum[i] += prefixSum[i - 1];

            if(i < n && musicSheet[i] > musicSheet[i + 1]) {
                prefixSum[i + 1]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++) {
            sb.append(prefixSum[questions[i][1]] - prefixSum[questions[i][0]]).append("\n");
        }

        return sb.toString();
    }
}

public class Problem21318 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        int q = Integer.parseInt(br.readLine());
        int[][] arr2 = new int[q][2];
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            arr2[i][0] = Integer.parseInt(st.nextToken());
            arr2[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution21318(n, arr1, q, arr2).solve());
        bw.flush();
        bw.close();
    }
}
