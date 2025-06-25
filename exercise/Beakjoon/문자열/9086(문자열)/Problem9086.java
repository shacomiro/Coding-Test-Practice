import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution9086 {
    private String str;

    public Solution9086(String str) {
        this.str = str;
    }

    public String solve() {
        return String.valueOf(str.charAt(0)) + String.valueOf(str.charAt(str.length() - 1));
    }
}

public class Problem9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            bw.write(new Solution9086(br.readLine()).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
