import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution5524 {
    private int n;
    private String[] names;

    public Solution5524(int n, String[] names) {
        this.n = n;
        this.names = names;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            sb.append(names[i].toLowerCase()).append("\n");
        }

        return sb.toString();
    }
}

public class Problem5524 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        bw.write(new Solution5524(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
