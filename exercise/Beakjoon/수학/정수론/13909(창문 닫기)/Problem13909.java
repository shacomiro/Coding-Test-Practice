import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution13909 {
    private int n;

    public Solution13909(int n) {
        this.n = n;
    }

    public String solve() {
        int count = 0;

        for(int i = 1; i * i <= n; i++) {
            count++;
        }

        return String.valueOf(count);
    }
}


public class Problem13909 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution13909(Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }
}
