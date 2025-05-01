import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution5637 {
    private String str;

    public Solution5637(String str) {
        this.str = str;
    }

    public String solve() {
        Pattern pattern = Pattern.compile("[a-zA-Z-]+");
        Matcher matcher = pattern.matcher(str);
        String longWord = "";

        while (matcher.find()) {
            String word = matcher.group();

            if (word.length() > longWord.length()) {
                longWord = word;
            }
        }

        return longWord.toLowerCase();
    }
}

public class Problem5637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            if (st.countTokens() == 0) {
                continue;
            }
            String str = "";
            while (st.hasMoreTokens()) {
                str = st.nextToken();
                sb.append(str).append(" ");
            }
            if (str.equals("E-N-D")) {
                break;
            }
        }

        bw.write(new Solution5637(sb.toString()).solve());
        bw.flush();
        bw.close();
    }
}
