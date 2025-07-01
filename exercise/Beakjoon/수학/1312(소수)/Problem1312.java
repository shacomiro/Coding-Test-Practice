import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution1312 {
    private int a;
    private int b;
    private int n;

    public Solution1312(int a, int b, int n) {
        this.a = a;
        this.b = b;
        this.n = n;
    }

    public String solve() {
        int remainder = a % b;

        for(int i = 1; i < n; i++) {
            remainder *= 10;
            remainder %= b;
        }
        remainder *= 10;

        return String.valueOf(remainder / b);
    }
}

public class Problem1312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        bw.write(new Solution1312(a, b, n).solve());
        bw.flush();
        bw.close();
    }
}
