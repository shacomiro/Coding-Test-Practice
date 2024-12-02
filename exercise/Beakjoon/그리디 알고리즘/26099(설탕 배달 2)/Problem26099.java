import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution26099 {
    private long n;

    public Solution26099(long n) {
        this.n = n;
    }

    public String solve() {
        long cnt = 0;

        while(n > 0 && n % 5 != 0) {
            cnt++;
            n -= 3;
        }
        cnt = (n % 5 == 0) ? cnt + n / 5 : -1;

        return String.valueOf(cnt);
    }
}

public class Problem26099 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution26099(Long.parseLong(br.readLine())).solve());
        bw.flush();
        bw.close();
    }
}
