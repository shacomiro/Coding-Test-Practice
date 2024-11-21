import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution1449 {
    private int l;
    private int[] positions;
    private boolean[] isTaped;

    public Solution1449(int n, int l, int[] positions) {
        this.l = l;
        this.positions = positions;
        this.isTaped = new boolean[1001];
    }

    public String solve() {
        int cnt = 0;
        Arrays.sort(positions);

        for(int p : positions) {
            if(isTaped[p]) {
                continue;
            }

            cnt++;
            int tapeEnd = (p + l < 1001) ? p + l : 1001;

            for(int i = p + 1; i < tapeEnd; i++) {
                isTaped[i] = true;
            }
        }

        return String.valueOf(cnt);
    }
}

public class Problem1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution1449(n, l, arr).solve());
        bw.flush();
        bw.close();
    }
}
