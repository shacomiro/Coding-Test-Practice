import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution34032 {
    private int n;
    private String s;

    public Solution34032(int n, String s) {
        this.n = n;
        this.s = s;
    }

    public String solve() {
        int agreeCnt = 0;
        int majority = (n / 2) + ((n % 2 == 0) ? 0 : 1);

        for (int i = 0; i < n; i++) {
            agreeCnt += (s.charAt(i) == 'O') ? 1 : 0;
        }

        return (agreeCnt >= majority) ? "Yes" : "No";
    }
}

public class Problem34032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        bw.write(new Solution34032(n, str).solve());
        bw.flush();
        bw.close();
    }
}
