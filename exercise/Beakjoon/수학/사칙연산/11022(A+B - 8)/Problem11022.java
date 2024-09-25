import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution11022 {
    private int id;
    private int a;
    private int b;

    public Solution11022(int id, int a, int b) {
        this.id = id;
        this.a = a;
        this.b = b;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();
        sb.append("Case #").append(id).append(": ").append(a).append(" + ").append(b).append(" = ").append(a + b);

        return sb.toString();
    }
}


public class Problem11022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            bw.write(new Solution11022(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
