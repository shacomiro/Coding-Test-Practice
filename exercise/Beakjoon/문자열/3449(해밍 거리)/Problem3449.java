import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution3449 {
    private String s1;
    private String s2;

    public Solution3449(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public String solve() {
        int hammingDistance = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                hammingDistance++;
            }
        }

        return "Hamming distance is " + hammingDistance + ".";
    }
}

public class Problem3449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            bw.write(new Solution3449(br.readLine(), br.readLine()).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
