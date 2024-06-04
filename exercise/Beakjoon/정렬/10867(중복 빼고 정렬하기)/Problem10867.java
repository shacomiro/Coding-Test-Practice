import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Solution10867 {
    private SortedSet<Integer> numbers;

    public Solution10867(List<Integer> list) {
        this.numbers = new TreeSet<>(list);
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();
        for(int number : numbers) {
            sb.append(number).append(" ");
        }

        return sb.toString();
    }
}

public class Problem10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>(n);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        bw.write(new Solution10867(list).solve());
        bw.flush();
        bw.close();
    }
}