import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution1032 {
    private int n;
    private String[] filenames;

    public Solution1032(int n, String[] filenames) {
        this.n = n;
        this.filenames = filenames;
    }

    public String solve() {
        if(n == 1) {
            return filenames[0];
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < filenames[0].length(); i++) {
            boolean isSame = true;

            for(int j = 1; j < n; j++) {
                if(filenames[j].charAt(i) != filenames[0].charAt(i)) {
                    isSame = false;
                    break;
                }
            }

            sb.append((isSame) ? filenames[0].charAt(i) : '?');
        }

        return sb.toString();
    }
}


public class Problem1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        bw.write(new Solution1032(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
