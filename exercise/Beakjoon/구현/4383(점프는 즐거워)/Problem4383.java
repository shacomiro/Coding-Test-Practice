import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution4383 {
    private int n;
    private int[] sequence;
    private boolean[] isChecked;

    public Solution4383(int n, int[] sequence) {
        this.n = n;
        this.sequence = sequence;
        this.isChecked = new boolean[n];
    }

    public String solve() {
        for (int i = 0; i < n - 1; i++) {
            int diff = Math.abs(sequence[i] - sequence[i + 1]);

            if (0 < diff && diff < n) {
                isChecked[diff] = true;
            }
        }

        for (int i = 1; i < n; i++) {
            if (!isChecked[i]) {
                return "Not jolly";
            }
        }

        return "Jolly";
    }
}

public class Problem4383 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String input;

        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            bw.write(new Solution4383(n, arr).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
