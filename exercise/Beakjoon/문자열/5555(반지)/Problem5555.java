import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution5555 {
    private String word;
    private int n;
    private String[] rings;

    public Solution5555(String word, int n, String[] rings) {
        this.word = word;
        this.n = n;
        this.rings = rings;
    }

    public String solve() {
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            if(rings[i].concat(rings[i].substring(0, word.length() - 1)).contains(word)) {
                cnt++;
            }
        }

        return String.valueOf(cnt);
    }
}

public class Problem5555 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        bw.write(new Solution5555(str, n, arr).solve());
        bw.flush();
        bw.close();
    }
}
