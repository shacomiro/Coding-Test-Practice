import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution10178 {
    private int c;
    private int v;

    public Solution10178(int c, int v) {
        this.c = c;
        this.v = v;
    }

    public String solve() {
        return "You get " + (c / v) + " piece(s) and your dad gets " + (c % v) + " piece(s).";
    }
}

public class Problem10178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            bw.write(new Solution10178(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
