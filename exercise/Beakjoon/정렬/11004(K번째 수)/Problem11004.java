import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Solution11004 {
    private List<Integer> numbers;
    private int k;

    public Solution11004(List<Integer> numbers, int k) {
        this.numbers = numbers;
        this.k = k;
    }

    public String solve() {
        Collections.sort(numbers);

        return String.valueOf(numbers.get(k - 1));
    }
}

public class Problem11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>(n);
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        bw.write(new Solution11004(list, k).solve());
        bw.flush();
        bw.close();
    }
}
