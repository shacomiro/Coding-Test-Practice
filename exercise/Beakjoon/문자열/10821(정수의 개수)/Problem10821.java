import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution1082 {
    private String str;

    public Solution1082(String str) {
        this.str = str;
    }

    public String solve() {
        return String.valueOf(new StringTokenizer(str, ",").countTokens());
    }
}

public class Problem10821 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution1082(br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}
