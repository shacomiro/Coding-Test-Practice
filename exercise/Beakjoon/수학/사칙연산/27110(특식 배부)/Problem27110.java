import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution27110 {
    private int n;
    private int a;
    private int b;
    private int c;

    public Solution27110(int n, int a, int b, int c) {
        this.n = n;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String solve() {
        int sum = 0;

        sum += (n - a >= 0) ? a : n;
        sum += (n - b >= 0) ? b : n;
        sum += (n - c >= 0) ? c : n;

        return String.valueOf(sum);
    }
}

public class Problem27110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        bw.write(new Solution27110(n, a, b, c).solve());
        bw.flush();
        bw.close();
    }
}
