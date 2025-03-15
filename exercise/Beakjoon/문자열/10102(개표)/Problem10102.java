import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution10102 {
    private int v;
    private String vote;

    public Solution10102(int v, String vote) {
        this.v = v;
        this.vote = vote;
    }

    public String solve() {
        int a = 0;
        int b = 0;

        for(int i = 0; i < v; i++) {
            if(vote.charAt(i) == 'A') {
                a++;
            } else {
                b++;
            }
        }

        return String.valueOf((a == b) ? "Tie" : ((a > b) ? 'A' : 'B'));
    }
}

public class Problem10102 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution10102(Integer.parseInt(br.readLine()), br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}
