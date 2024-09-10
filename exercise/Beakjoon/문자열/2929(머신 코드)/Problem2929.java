import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution2929 {
    private Pattern pattern;
    private Matcher matcher;

    public Solution2929(String machineCode) {
        this.pattern = Pattern.compile("([A-Z][a-z]*)");
        this.matcher = pattern.matcher(machineCode);
    }

    public String solve() {
        int cntNOP = 0;

        while(matcher.find()) {
            int start = (matcher.start() + cntNOP) % 4;
            cntNOP += start == 0 ? 0 : 4 - start;
        }

        return String.valueOf(cntNOP);
    }
}

public class Problem2929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution2929(br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}
