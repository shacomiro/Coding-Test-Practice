import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution14405 {
    private static final String[] pikachu = {"pi", "ka", "chu"};
    private String str;

    public Solution14405(String str) {
        this.str = str;
    }

    public String solve() {
        for(String pkc : pikachu) {
            str = str.replaceAll(pkc, "#");
        }
        str = str.replaceAll("#", "");

        return String.valueOf((str.length() > 0) ? "NO" : "YES");
    }
}

public class Problem14405 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution14405(br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}
