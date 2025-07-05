import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution2993 {
    private String word;

    public Solution2993(String word) {
        this.word = word;
    }

    public String solve() {
        String result = word;

        for (int i = 1; i < word.length() - 1; i++) {
            for (int j = i + 1; j < word.length(); j++) {
                String flipWord = new StringBuilder(word.substring(0, i)).reverse().toString()
                        + new StringBuilder(word.substring(i, j)).reverse().toString()
                        + new StringBuilder(word.substring(j, word.length())).reverse().toString();

                if ((flipWord.compareTo(result) < 0)) {
                    result = flipWord;
                }
            }
        }
        return result;
    }
}

public class Problem2993 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution2993(br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}
