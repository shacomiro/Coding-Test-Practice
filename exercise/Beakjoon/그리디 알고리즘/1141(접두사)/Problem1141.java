import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution1141 {
    private int n;
    private String[] words;
    private Set<String> nonPrefixes;

    public Solution1141(int n, String[] words) {
        this.n = n;
        this.words = words;
        this.nonPrefixes = new HashSet<>();
    }

    public String solve() {
        Arrays.sort(words, (w1, w2) -> w2.length() - w1.length());

        for(String word : words) {
            if(nonPrefixes.isEmpty()) {
                nonPrefixes.add(word);
            }
            
            boolean isPrefix = false;
            for(String nonPrefix : nonPrefixes) {
                if(nonPrefix.startsWith(word)) {
                    isPrefix = true;
                    break;
                }
            }

            if(!isPrefix) {
                nonPrefixes.add(word);
            }
        }

        return String.valueOf(nonPrefixes.size());
    }
}

public class Problem1141 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        bw.write(new Solution1141(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
