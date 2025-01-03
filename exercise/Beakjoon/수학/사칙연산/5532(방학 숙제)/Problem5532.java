import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution5532 {
    private int l;
    private int a;
    private int b;
    private int c;
    private int d;

    public Solution5532(int l, int a, int b, int c, int d) {
        this.l = l;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public String solve() {
        while(a > 0 || b > 0) {
            a -= c;
            b -= d;
            l--;
        }

        return String.valueOf(l);
    }
}

public class Problem5532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int l = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());

        bw.write(new Solution5532(l, a, b, c, d).solve());
        bw.flush();
        bw.close();
    }
}
