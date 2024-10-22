import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution25314 {
    private int n;

    public Solution25314(int n) {
        this.n = n;
    }

    public String solve() {
        return "long ".repeat(n / 4) + "int";
    }
}

public class Problem25314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution25314(Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }
}
