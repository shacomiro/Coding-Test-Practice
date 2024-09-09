import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution1550 {
    private String hexadecimalStr;

    public Solution1550(String hexadecimalStr) {
        this.hexadecimalStr = hexadecimalStr;
    }

    public String solve() {
        return String.valueOf(Integer.parseInt(hexadecimalStr, 16));
    }
}

public class Problem1550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution1550(br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}
