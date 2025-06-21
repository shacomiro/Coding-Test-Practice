import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution4796 {
    private int l;
    private int p;
    private int v;

    public Solution4796(int l, int p, int v) {
        this.l = l;
        this.p = p;
        this.v = v;
    }

    public String solve() {
        return String.valueOf((v / p * l) + Math.min(v % p, l));
    }
}

public class Problem4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String input;
        int i = 0;

        while (!(input = br.readLine()).equals("0 0 0")) {
            st = new StringTokenizer(input);
            i++;

            bw.write("Case " + i + ": ");
            bw.write(new Solution4796(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
