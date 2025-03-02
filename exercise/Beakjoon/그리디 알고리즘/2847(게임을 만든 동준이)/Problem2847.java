import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution2847 {
    private int n;
    private int[] levels;

    public Solution2847(int n, int[] levels) {
        this.n = n;
        this.levels = levels;
    }

    public String solve() {
        int cnt = 0;

        for(int i = n - 2; i >= 0; i--) {
            while(levels[i] >= levels[i + 1]) {
                levels[i]--;
                cnt++;
            }
        }

        return String.valueOf(cnt);
    }
}

public class Problem2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(new Solution2847(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
