import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution9933 {
    private Set<String> words;

    public Solution9933(List<String> words) {
        this.words = new HashSet<>(words);
    }

    public String solve() {
        int length = 0;
        char middleChar = '?';

        for (String w : words) {
            if (words.contains(new StringBuilder(w).reverse().toString())) {
                length = w.length();
                middleChar = w.charAt(w.length() / 2);

                break;
            }
        }

        return length + " " + middleChar;
    }
}

public class Problem9933 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        bw.write(new Solution9933(list).solve());
        bw.flush();
        bw.close();
    }
}
