import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution24883 {
    private String alphabet;

    public Solution24883(String alphabet) {
        this.alphabet = alphabet;
    }

    public String solve() {
        return alphabet.equalsIgnoreCase("n") ? "Naver D2" : "Naver Whale";
    }
}

public class Problem24883 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution24883(br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}
