import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution2491 {
    private int n;
    private int[] sequences;

    public Solution2491(int n, int[] sequences) {
        this.n = n;
        this.sequences = sequences;
    }

    public String solve() {
        int up = 1;
        int down = 1;
        int max = 1;

        for(int i = 1; i < n; i++) {
            if(sequences[i] > sequences[i - 1]) {
                up += 1;
                down = 1;
            } else if(sequences[i] < sequences[i - 1]) {
                up = 1;
                down += 1;
            } else {
                up += 1;
                down += 1;
            }

            max = Math.max(max, Math.max(up, down));
        }

        return String.valueOf(max);
    }
}


public class Problem2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution2491(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
