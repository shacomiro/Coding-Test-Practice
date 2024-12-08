import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

class Solution3448 {
    private List<String> strings;

    public Solution3448(List<String> strings) {
        this.strings = strings;
    }

    public String solve() {
        int rCnt = 0;
        int aCnt = 0;

        for(String str : strings) {
            aCnt += str.length();

            for(char c : str.toCharArray()) {
                if(c == '#') {
                    rCnt++;
                }
            }
        }

        double recognitionRate = Math.round(((double) (aCnt - rCnt) / aCnt) * 100 * 10) / 10.0;
        String format = (recognitionRate == (int) recognitionRate) ? "Efficiency ratio is %.0f%%." : "Efficiency ratio is %.1f%%.";

        return String.format(format, recognitionRate);
    }
}

public class Problem3448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            List<String> list = new ArrayList<>();
            String input;

            while(!(input = br.readLine()).isEmpty()) {
                list.add(input);
            }
            bw.write(new Solution3448(list).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
