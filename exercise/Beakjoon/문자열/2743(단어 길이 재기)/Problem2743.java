import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution2743 {
    private String str;

    public Solution2743(String str) {
        this.str = str;
    }

    public String solve() {
        return String.valueOf(str.length());
    }
}

public class Problem2743 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution2743(br.readLine()).solve());
        bw.flush();
        bw.close();
    }
    
}
