import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution10988 {
    private String str;

    public Solution10988(String str) {
        this.str = str;
    }

    public String solve() {
        int lt = 0;
        int rt = str.length() - 1;

        while(lt < rt) {
            if(str.charAt(lt++) != str.charAt(rt--)) {
                return String.valueOf(0);
            }
        }

        return String.valueOf(1);
    }
}

public class Problem10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution10988(br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}
