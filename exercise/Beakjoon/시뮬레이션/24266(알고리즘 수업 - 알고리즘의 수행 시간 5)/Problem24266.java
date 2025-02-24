import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution24266 {
    private long n;

    public Solution24266(int n) {
        this.n = n;
    }

    public String solve() {
        return String.valueOf((n * n * n) + "\n3");
    }
}

public class Problem24266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution24266(Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }
}
