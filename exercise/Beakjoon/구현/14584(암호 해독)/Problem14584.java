import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution14584 {
    private String password;
    private int n;
    private String[] words;

    public Solution14584(String password, int n, String[] words) {
        this.password = password;
        this.n = n;
        this.words = words;
    }

    public String solve() {
        char[] chars = password.toCharArray();
        boolean found = false;
        String decode = "";

        for (int i = 0; !found && i < 26; i++) {
            for (int j = 0; j < password.length(); j++) {
                chars[j] = (char) (97 + (chars[j] - 97 + 1) % 26);
            }

            decode = String.valueOf(chars);
            for (int k = 0; k < n; k++) {
                if (decode.contains(words[k])) {
                    found = true;
                    break;
                }
            }
        }

        return decode;
    }
}

public class Problem14584 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        bw.write(new Solution14584(str, n, arr).solve());
        bw.flush();
        bw.close();
    }
}
