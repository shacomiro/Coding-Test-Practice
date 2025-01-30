import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution31495 {
    private String str;

    public Solution31495(String str) {
        this.str = str;
    }

    public String solve() {
        int from = str.indexOf("\"");
        int to = str.lastIndexOf("\"");

        if(from != 0 || to != str.length() - 1 || from == to) {
            return "CE";
        }

        String innerStr = str.substring(from + 1, to).trim();
        
        return (innerStr.isEmpty()) ? "CE" : innerStr;
    }
}

public class Problem31495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution31495(br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}
