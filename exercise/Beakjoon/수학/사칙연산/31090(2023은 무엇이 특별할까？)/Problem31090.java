import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution31090 {
    private int year;

    public Solution31090(int year) {
        this.year = year;
    }

    public String solve() {
        return ((year + 1) % (year % 100) == 0) ? "Good" : "Bye";
    }
}

public class Problem31090 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            bw.write(new Solution31090(Integer.parseInt(br.readLine())).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
