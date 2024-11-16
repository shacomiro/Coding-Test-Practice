import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution32652 {
    private int k;
    private StringBuilder sb;

    public Solution32652(int k) {
        this.k = k;
        this.sb = new StringBuilder("AKA");
    }

    public String solve() {
        for(int i = 0; i < k; i++) {
            sb.append("RAKA");
        }

        return sb.toString();
    }
}


public class Problem32652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution32652(Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }
}
