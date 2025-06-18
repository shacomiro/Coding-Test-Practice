import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution27294 {
    private int t;
    private int s;

    public Solution27294(int t, int s) {
        this.t = t;
        this.s = s;
    }

    public String solve() {
        return (12 <= t && t <= 16 && s == 0) ? "320" : "280";
    }
}

public class Problem27294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        bw.write(new Solution27294(t, s).solve());
        bw.flush();
        bw.close();
    }
}
