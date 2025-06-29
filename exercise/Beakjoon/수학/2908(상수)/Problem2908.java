import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution2908 {
    private int a;
    private int b;

    public Solution2908(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public String solve() {
        int ap = getReverseNumber(a);
        int bp = getReverseNumber(b);

        return String.valueOf(Math.max(ap, bp));
    }

    private int getReverseNumber(int number) {
        return ((number % 10) * 100) + (((number % 100) / 10) * 10) + (number / 100);
    }
}

public class Problem2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        bw.write(new Solution2908(a, b).solve());
        bw.flush();
        bw.close();
    }
}
