import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution1964 {
    private int n;

    public Solution1964(int n) {
        this.n = n;
    }

    public String solve() {
        if(n == 1) {
            return String.valueOf(5);
        }

        int dots = 5;

        for(int step = 2; step <= n; step++) {
            dots = (dots + 4 + ((step - 1) * 3)) % 45678;
        }

        return String.valueOf(dots);
    }
}


public class Problem1964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution1964(Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }
}
