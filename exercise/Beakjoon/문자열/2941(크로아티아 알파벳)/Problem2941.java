import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution2941 {
    private String[] croatianAlphabets;
    private String word;

    public Solution2941(String word) {
        this.croatianAlphabets = new String[] {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        this.word = word;
    }

    public String solve() {
        for(String ca : croatianAlphabets) {
            if(word.contains(ca)) {
                word = word.replaceAll(ca, "*");
            }
        }

        return String.valueOf(word.length());
    }
}

public class Problem2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution2941(br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}
