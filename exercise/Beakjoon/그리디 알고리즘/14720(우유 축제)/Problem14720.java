import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution14720 {
    private int n;
    private int[] milks;

    public Solution14720(int n, int[] milks) {
        this.n = n;
        this.milks = milks;
    }

    public String solve() {
        int count = 0;
        int next = 0;

        for (int i = 0; i < n; i++) {
            if (milks[i] == next) {
                count++;
                next = (next + 1) % 3;
            }
        }

        return String.valueOf(count);
    }
}

public class Problem14720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution14720(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
