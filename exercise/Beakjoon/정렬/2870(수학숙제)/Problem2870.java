import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution2870 {
    private List<String> words;
    private List<String> numbers;

    public Solution2870(List<String> words) {
        this.words = words;
        this.numbers = new ArrayList<>();
    }

    public String solve() {
        StringBuilder sb;

        for(String word : words) {
            sb = new StringBuilder();

            for(char c : word.toCharArray()) {
                if('0' <= c && c <= '9') {
                    if(sb.length() == 1 && sb.charAt(0) == '0') {
                        sb.deleteCharAt(0);
                    }
                    sb.append(c);
                } else if(sb.length() > 0) {
                    numbers.add(sb.toString());
                    sb = new StringBuilder();
                }
            }

            if(sb.length() > 0) {
                numbers.add(sb.toString());
            }
        }

        Collections.sort(numbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        sb = new StringBuilder();
        for(String n : numbers) {
            sb.append(n).append("\n");
        }

        return sb.toString();
    }
}

public class Problem2870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        bw.write(new Solution2870(list).solve());
        bw.flush();
        bw.close();
    }
}
