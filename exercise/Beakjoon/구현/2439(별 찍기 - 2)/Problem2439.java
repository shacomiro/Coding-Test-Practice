import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution2439 {
    private int n;

    public Solution2439(int n) {
        this.n = n;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(j < n - i - 1) {
                    sb.append(" ");
                } else {
                    sb.append("*");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

public class Problem2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution2439(Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }
}
