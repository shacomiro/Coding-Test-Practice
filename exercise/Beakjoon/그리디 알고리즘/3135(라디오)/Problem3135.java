import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution3135 {
    private int a;
    private int b;
    private int n;
    private int[] favorites;

    public Solution3135(int a, int b, int n, int[] favorites) {
        this.a = a;
        this.b = b;
        this.n = n;
        this.favorites = favorites;
    }

    public String solve() {
        int min = Math.abs(a - b);

        for (int i = 0; i < n; i++) {
            min = Math.min(min, 1 + Math.abs(favorites[i] - b));
        }

        return String.valueOf(min);
    }
}

public class Problem3135 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(new Solution3135(a, b, n, arr).solve());
        bw.flush();
        bw.close();
    }
}