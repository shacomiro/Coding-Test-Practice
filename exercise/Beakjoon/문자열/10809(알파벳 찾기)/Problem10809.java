import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution10809 {
    private String str;

    public Solution10809(String str) {
        this.str = str;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        for(int i = 'a'; i <= 'z'; i++) {
            sb.append(str.indexOf(i, 0)).append(" ");
        }

        return sb.toString();
    }
}

public class Problem10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        bw.write(new Solution10809(s).solve());
        bw.flush();
        bw.close();
    }
}
