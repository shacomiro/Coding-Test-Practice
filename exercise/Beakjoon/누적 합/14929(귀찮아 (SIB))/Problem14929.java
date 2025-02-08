import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution14929 {
    private int n;
    private int[] x;

    public Solution14929(int n, int[] x) {
        this.n = n;
        this.x = x;
    }

    public String solve() {
        int temp = 0;
        for(int i = 1; i <= n; i++) {
            temp += x[i];
        }

        long sum = 0;
        for(int i = 1; i <= n; i++) {
            temp -= x[i];
            sum += x[i] * temp;
        }

        return String.valueOf(sum);
    }
}

public class Problem14929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution14929(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
