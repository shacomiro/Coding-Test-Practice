import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution5598 {
    private String caesarWord;

    public Solution5598(String caesarWord) {
        this.caesarWord = caesarWord;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder(caesarWord.length());

        for (int i = 0; i < caesarWord.length(); i++) {
            sb.append((char) ('A' + (caesarWord.charAt(i) - 'A' - 3 + 26) % 26));
        }

        return sb.toString();
    }
}

public class Problem5598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution5598(br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}
