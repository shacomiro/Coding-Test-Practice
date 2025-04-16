import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution4470 {
    private int n;
    private String[] sentences;

    public Solution4470(int n, String[] sentences) {
        this.n = n;
        this.sentences = sentences;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            sb.append(i + 1).append(". ").append(sentences[i]).append("\n");
        }

        return sb.toString();
    }
}

public class Problem4470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        bw.write(new Solution4470(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
