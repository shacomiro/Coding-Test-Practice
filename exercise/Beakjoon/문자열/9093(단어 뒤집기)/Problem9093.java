import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution9093 {
    private StringTokenizer st;
    private StringBuilder sb;

    public Solution9093(String str) {
        st = new StringTokenizer(str);
        sb = new StringBuilder();
    }

    public String solve() {
        while(st.hasMoreTokens()) {
            sb.append(new StringBuilder(st.nextToken()).reverse()).append(" ");
        }

        return sb.toString();
    }
}

public class Problem9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            bw.write(new Solution9093(br.readLine()).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}