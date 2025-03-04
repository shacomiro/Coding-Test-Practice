import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution1543 {
    private String document;
    private String search;

    public Solution1543(String document, String search) {
        this.document = document;
        this.search = search;
    }

    public String solve() {
        int cnt = 0;

        while(document.contains(search)) {
            cnt++;
            document = document.replaceFirst(search, "*");
        }

        return String.valueOf(cnt);
    }
}

public class Problem1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution1543(br.readLine(), br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}
