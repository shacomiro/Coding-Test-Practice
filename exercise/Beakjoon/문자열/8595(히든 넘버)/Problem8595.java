import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution8595 {
    private Pattern pattern;
    private Matcher matcher;

    public Solution8595(int n, String word) {
        this.pattern = Pattern.compile("([0-9]+)");
        this.matcher = pattern.matcher(word);
    }

    public String solve() {
        long sum = 0;

        while (matcher.find()) {
            sum += Long.parseLong(matcher.group());
        }

        return String.valueOf(sum);
    }
}

public class Problem8595 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution8595(Integer.parseInt(br.readLine()), br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}
