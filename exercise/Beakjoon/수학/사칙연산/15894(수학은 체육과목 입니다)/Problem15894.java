import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution15894 {
    private long n;

    public Solution15894(int n) {
        this.n = n;
    }

    public String solve() {
        return String.valueOf(4 * n);
    }
}

public class Problem15894 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution15894(Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }
}
