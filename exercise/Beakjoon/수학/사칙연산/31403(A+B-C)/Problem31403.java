import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution31403 {
    private String a;
    private String b;
    private String c;

    public Solution31403(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String solve() {
        String strNum = String.valueOf(Integer.parseInt(a + b) - Integer.parseInt(c));
        String intNum = String.valueOf(Integer.parseInt(a) + Integer.parseInt(b) - Integer.parseInt(c));

        return String.valueOf(intNum + "\n" + strNum);
    }
}

public class Problem31403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution31403(br.readLine(), br.readLine(), br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}
