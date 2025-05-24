import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution23303 {
    private String str;

    public Solution23303(String str) {
        this.str = str;
    }

    public String solve() {
        return (str.toUpperCase().contains("D2")) ? "D2" : "unrated";
    }
}

public class Problem23303 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution23303(br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}
