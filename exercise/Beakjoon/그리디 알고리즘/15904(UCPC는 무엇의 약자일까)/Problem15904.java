import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution15904 {
    private final String UCPC = "UCPC";
    private String str;

    public Solution15904(String str) {
        this.str = str;
    }

    public String solve() {
        int i = 0;
        for(int j = 0; j < str.length(); j++) {
            if(str.charAt(j) == UCPC.charAt(i)) {
                i++;
            }

            if(i == 4) {
                return "I love UCPC";
            }
        }

        return "I hate UCPC";
    }
}

public class Problem15904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution15904(br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}
