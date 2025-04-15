import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution16499 {
    private int n;
    private String[] words;
    private Set<String> groups;

    public Solution16499(int n, String[] words) {
        this.n = n;
        this.words = words;
        this.groups = new HashSet<>();
    }

    public String solve() {
        for(int i = 0; i < n; i++) {
            char[] chars = words[i].toCharArray();
            Arrays.sort(chars);
            String sortedWord = String.valueOf(chars);

            groups.add(sortedWord);
        }

        return String.valueOf(groups.size());
    }
}

public class Problem16499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        bw.write(new Solution16499(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
