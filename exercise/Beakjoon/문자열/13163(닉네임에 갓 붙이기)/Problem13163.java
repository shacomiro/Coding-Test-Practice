import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution13163 {
    private int n;
    private String[] nicknames;

    public Solution13163(int n, String[] nicknames) {
        this.n = n;
        this.nicknames = nicknames;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(nicknames[i]);

            st.nextToken();
            sb.append("god");
            while (st.hasMoreTokens()) {
                sb.append(st.nextToken());
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

public class Problem13163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        bw.write(new Solution13163(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
