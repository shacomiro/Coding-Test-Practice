import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Solution1755 {
    private static final Map<Integer, String> numberToWord = Map.of(0, "zero", 1, "one", 2, "two", 3, "three", 4,
            "four", 5, "five", 6, "six", 7, "seven", 8, "eight", 9, "nine");
    private int m;
    private int n;
    private Map<String, Integer> results;

    public Solution1755(int m, int n) {
        this.m = m;
        this.n = n;
        this.results = new HashMap<>();
    }

    public String solve() {
        for (int number = m; number <= n; number++) {
            results.put(((number / 10 > 0) ? (numberToWord.get(number / 10) + " " + numberToWord.get(number % 10))
                    : numberToWord.get(number % 10)), number);
        }

        List<String> keySet = new ArrayList<>(results.keySet());
        Collections.sort(keySet);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keySet.size(); i++) {
            sb.append(results.get(keySet.get(i))).append(((i + 1) % 10 == 0) ? "\n" : " ");
        }

        return sb.toString();
    }
}

public class Problem1755 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        bw.write(new Solution1755(m, n).solve());
        bw.flush();
        bw.close();
    }
}
