import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution4458 {
    private int n;
    private String[] paragraphs;

    public Solution4458(int n, String[] paragraphs) {
        this.n = n;
        this.paragraphs = paragraphs;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            StringBuilder p = new StringBuilder(paragraphs[i]);
            p.setCharAt(0, Character.toUpperCase(paragraphs[i].charAt(0)));
            
            sb.append(p).append("\n");
        }

        return sb.toString();
    }
}

public class Problem4458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        bw.write(new Solution4458(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
