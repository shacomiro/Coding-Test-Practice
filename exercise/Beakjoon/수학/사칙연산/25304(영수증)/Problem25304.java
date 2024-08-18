import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution25304 {
    private int totalPrice;
    private List<int[]> bill;

    public Solution25304(int totalPrice, List<int[]> bill) {
        this.totalPrice = totalPrice;
        this.bill = bill;
    }

    public String solve() {
        for(int[] b : bill) {
            totalPrice -= b[0] * b[1];
        }

        return totalPrice == 0 ? "Yes" : "No";
    }
}

public class Problem25304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int x = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        bw.write(new Solution25304(x, list).solve());
        bw.flush();
        bw.close();
    }
}
