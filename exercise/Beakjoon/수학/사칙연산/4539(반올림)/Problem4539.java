import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution4539 {
    private int x;

    public Solution4539(int x) {
        this.x = x;
    }

    public String solve() {
        int digits = 10;

        while (x >= digits) {
            int remain = x % digits;

            if (remain >= 5 * (digits / 10)) {
                x += digits;
            }
            x -= remain;

            digits *= 10;
        }

        return String.valueOf(x);
    }
}

public class Problem4539 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            bw.write(new Solution4539(Integer.parseInt(br.readLine())).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
