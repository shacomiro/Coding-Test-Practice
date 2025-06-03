import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution2966 {
    private final char[] ADRIAN = { 'A', 'B', 'C' };
    private final char[] BRUNO = { 'B', 'A', 'B', 'C' };
    private final char[] GORAN = { 'C', 'C', 'A', 'A', 'B', 'B' };
    private int n;
    private String answer;

    public Solution2966(int n, String answer) {
        this.n = n;
        this.answer = answer;
    }

    public String solve() {
        int adrian = 0;
        int bruno = 0;
        int goran = 0;

        for (int i = 0; i < n; i++) {
            if (ADRIAN[i % 3] == answer.charAt(i)) {
                adrian++;
            }
            if (BRUNO[i % 4] == answer.charAt(i)) {
                bruno++;
            }
            if (GORAN[i % 6] == answer.charAt(i)) {
                goran++;
            }
        }

        int max = Math.max(adrian, Math.max(bruno, goran));
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n");
        if (adrian == max) {
            sb.append("Adrian").append("\n");
        }
        if (bruno == max) {
            sb.append("Bruno").append("\n");
        }
        if (goran == max) {
            sb.append("Goran").append("\n");
        }

        return sb.toString();
    }
}

public class Problem2966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        bw.write(new Solution2966(n, str).solve());
        bw.flush();
        bw.close();
    }
}