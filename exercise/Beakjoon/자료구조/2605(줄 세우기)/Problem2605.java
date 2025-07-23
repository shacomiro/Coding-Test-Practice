import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Solution2605 {
    private int n;
    private int[] numbers;
    private List<Integer> order;

    public Solution2605(int n, int[] numbers) {
        this.n = n;
        this.numbers = numbers;
        this.order = new LinkedList<>();
    }

    public String solve() {
        int currStudentId = 1;

        for (int i = 0; i < n; i++) {
            order.add(order.size() - numbers[i], currStudentId);
            currStudentId++;
        }

        StringBuilder sb = new StringBuilder();
        for (int o : order) {
            sb.append(o).append(" ");
        }

        return sb.toString();
    }
}

public class Problem2605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution2605(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
