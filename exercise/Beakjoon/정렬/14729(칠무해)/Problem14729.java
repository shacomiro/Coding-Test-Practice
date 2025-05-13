import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Solution14729 {
    private int n;
    private double[] scores;

    public Solution14729(int n, double[] scores) {
        this.n = n;
        this.scores = scores;
    }

    public String solve() {
        Arrays.sort(scores);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            sb.append(String.format("%.3f", scores[i])).append("\n");
        }

        return sb.toString();
    }
}

public class Problem14729 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        bw.write(new Solution14729(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
