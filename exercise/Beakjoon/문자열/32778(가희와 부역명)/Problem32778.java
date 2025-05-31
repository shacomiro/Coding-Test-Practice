import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution32778 {
    private Pattern pattern;
    private Matcher matcher;

    public Solution32778(String stationInfo) {
        this.pattern = Pattern.compile("^(.+?)(?:\\s*\\((.*?)\\))?$");
        this.matcher = pattern.matcher(stationInfo);
    }

    public String solve() {
        String stationName = "";
        String subStationName = "";

        if (matcher.find()) {
            stationName = matcher.group(1);
            subStationName = (matcher.group(2) != null) ? matcher.group(2) : "-";
        }

        return stationName + "\n" + subStationName;
    }
}

public class Problem32778 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution32778(br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}
