import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution2440 {
    private int n;

    public Solution2440(int n) {
        this.n = n;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = n; j > i; j--) {
                sb.append("*");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

public class Problem2440 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution2440(Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }
}
