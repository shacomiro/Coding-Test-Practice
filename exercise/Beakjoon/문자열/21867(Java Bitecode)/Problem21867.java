import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution21867 {
    private String code;

    public Solution21867(String code) {
        this.code = code;
    }

    public String solve() {
        String javaBiteCode = code.replaceAll("[JAVA]", "");

        return javaBiteCode.length() > 0 ? javaBiteCode : "nojava";
    }
}

public class Problem21867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        bw.write(new Solution21867(s).solve());
        bw.flush();
        bw.close();
    }
}
