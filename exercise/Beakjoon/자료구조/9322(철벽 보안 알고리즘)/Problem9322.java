import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution9322 {
    private int n;
    private String[] firstPublicKey;
    private String[] secondPublicKey;
    private String[] password;

    public Solution9322(int n, String[] firstPublicKey, String[] secondPublicKey, String[] password) {
        this.n = n;
        this.firstPublicKey = firstPublicKey;
        this.secondPublicKey = secondPublicKey;
        this.password = password;
    }

    public String solve() {
        Map<String, Integer> keyMap = new HashMap<>(n);
        String[] plaintext = new String[n];

        for (int i = 0; i < n; i++) {
            keyMap.put(firstPublicKey[i], i);
        }
        for (int i = 0; i < n; i++) {
            plaintext[keyMap.get(secondPublicKey[i])] = password[i];
        }

        return String.join(" ", plaintext);
    }
}

public class Problem9322 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] arr1 = new String[n];
            String[] arr2 = new String[n];
            String[] arr3 = new String[n];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr1[j] = st.nextToken();
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr2[j] = st.nextToken();
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr3[j] = st.nextToken();
            }

            bw.write(new Solution9322(n, arr1, arr2, arr3).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
