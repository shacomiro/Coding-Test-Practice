import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution6550 {
    private String s;
    private String t;

    public Solution6550(String s, String t) {
        this.s = s;
        this.t = t;
    }

    public String solve() {
        int i = 0;
        for(int j = 0; i < s.length() && j < t.length(); j++) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }

        return (i == s.length()) ? "Yes" : "No";
    }
}

public class Problem6550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String input;

        while((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            bw.write(new Solution6550(st.nextToken(), st.nextToken()).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
