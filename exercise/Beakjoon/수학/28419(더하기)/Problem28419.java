import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution28419 {
    private int n;
    private int[] sequence;

    public Solution28419(int n, int[] sequence) {
        this.n = n;
        this.sequence = sequence;
    }

    public String solve() {
        long odd = 0;
        long even = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                odd += sequence[i];
            } else {
                even += sequence[i];
            }
        }

        long diff = even - odd;

        return String.valueOf((n == 3 && diff < 0) ? -1 : Math.abs(diff));
    }
}

public class Problem28419 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution28419(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
