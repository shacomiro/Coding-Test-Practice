import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution9324 {
    private String message;
    private int[] count;

    public Solution9324(String message) {
        this.message = message;
        this.count = new int[26];
    }

    public String solve() {
        for(int i = 0; i < message.length(); i++) {
            char curr = message.charAt(i);
            count[curr - 'A']++;

            if(count[curr - 'A'] == 3) {
                if(i + 1 < message.length() && message.charAt(i + 1) == curr) {
                    count[curr - 'A'] = 0;
                    i++;
                } else {
                    return "FAKE";
                }
            }
        }

        return "OK";
    }
}

public class Problem9324 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            bw.write(new Solution9324(br.readLine()).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
