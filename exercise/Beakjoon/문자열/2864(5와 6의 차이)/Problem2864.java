import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution2864 {
    private String a;
    private String b;

    public Solution2864(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String solve() {
        int minA = Integer.parseInt(a.replaceAll("6", "5"));
        int maxA = Integer.parseInt(a.replaceAll("5", "6"));
        int minB = Integer.parseInt(b.replaceAll("6", "5"));
        int maxB = Integer.parseInt(b.replaceAll("5", "6"));

        return (minA + minB) + " " + (maxA + maxB);
    }
}

public class Problem2864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        bw.write(new Solution2864(st.nextToken(), st.nextToken()).solve());
        bw.flush();
        bw.close();
    }
}
