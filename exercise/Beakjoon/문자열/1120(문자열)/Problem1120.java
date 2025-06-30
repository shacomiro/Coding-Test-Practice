import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution1120 {
    private String a;
    private String b;

    public Solution1120(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String solve() {
        int minGap = 50;

        for (int i = 0; i <= b.length() - a.length(); i++) {
            int gap = 0;

            for (int j = 0; j < a.length(); j++) {
                if (b.charAt(i + j) != a.charAt(j)) {
                    gap++;
                }
            }

            minGap = Math.min(minGap, gap);
        }

        return String.valueOf(minGap);
    }
}

public class Problem1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        bw.write(new Solution1120(st.nextToken(), st.nextToken()).solve());
        bw.flush();
        bw.close();
    }
}
