import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution10987 {
    private String word;

    public Solution10987(String word) {
        this.word = word;
    }

    public String solve() {
        int count = 0;

        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == 'a' || 
                word.charAt(i) == 'e' ||
                word.charAt(i) == 'i' ||
                word.charAt(i) == 'o' ||
                word.charAt(i) == 'u') {
                    count++;
            }
        }

        return String.valueOf(count);
    }
}

public class Problem10987 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution10987(br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}
