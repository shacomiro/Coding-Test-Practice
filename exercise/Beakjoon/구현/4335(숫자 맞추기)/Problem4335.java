import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

class Solution4335 {
    private List<Integer> numbers;
    private List<String> answers;

    public Solution4335(List<Integer> numbers, List<String> answers) {
        this.numbers = numbers;
        this.answers = answers;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();
        int min = 1;
        int max = 10;

        for (int i = 0; i < numbers.size(); i++) {
            if (answers.get(i).equals("too high")) {
                max = Math.min(max, numbers.get(i) - 1);
            } else if (answers.get(i).equals("too low")) {
                min = Math.max(min, numbers.get(i) + 1);
            } else {
                sb.append((min <= numbers.get(i) && numbers.get(i) <= max) ? "Stan may be honest" : "Stan is dishonest")
                        .append("\n");
                min = 1;
                max = 10;
            }
        }

        return sb.toString();
    }
}

public class Problem4335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        List<Integer> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        while (!(input = br.readLine()).equals("0")) {
            list1.add(Integer.parseInt(input));
            list2.add(br.readLine());
        }

        bw.write(new Solution4335(list1, list2).solve());
        bw.flush();
        bw.close();
    }
}
