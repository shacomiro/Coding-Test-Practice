import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution12871 {
    private String s;
    private String t;

    public Solution12871(String s, String t) {
        this.s = s;
        this.t = t;    
    }

    public String solve() {
        return s.repeat(t.length()).equals(t.repeat(s.length())) ? "1" : "0";
    }
}

public class Problem12871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution12871(br.readLine(), br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}
