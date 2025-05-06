import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution15439 {
    private int n;

    public Solution15439(int n) {
        this.n = n;
    }

    public String solve() {
        return String.valueOf(n * (n - 1));
    }
}

public class Problem15439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution15439(Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }
}
