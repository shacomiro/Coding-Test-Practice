import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class Solution9996 {
    private Pattern pattern;
    private List<String> fileNames;
    
    public Solution9996(String patternString, List<String> fileNames) {
        this.pattern = Pattern.compile(getRegularExpression(patternString));
        this.fileNames = fileNames;
    }

    private String getRegularExpression(String patternString) {
        String[] parts = patternString.split("\\*", 2);

        return "^" + parts[0] + ".*" + parts[1] + "$";
    }
    
    public String solve() {
        StringBuilder sb = new StringBuilder();

        for(String fileName : fileNames) {
            sb.append(pattern.matcher(fileName).find() ? "DA" : "NE").append("\n");
        }

        return sb.toString();
    }
}

public class Problem9996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        List<String> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        bw.write(new Solution9996(s, list).solve());
        bw.flush();
        bw.close();
    }
}
