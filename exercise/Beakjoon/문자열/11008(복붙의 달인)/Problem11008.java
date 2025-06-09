import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution11008 {
    private String s;
    private String p;

    public Solution11008(String s, String p) {
        this.s = s;
        this.p = p;
    }

    public String solve() {
        int copyAndPaste = 0;

        while (s.contains(p)) {
            s = s.replaceFirst(p, "");
            copyAndPaste++;
        }

        return String.valueOf(copyAndPaste + s.length());
    }
}

public class Problem11008 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            bw.write(new Solution11008(st.nextToken(), st.nextToken()).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
