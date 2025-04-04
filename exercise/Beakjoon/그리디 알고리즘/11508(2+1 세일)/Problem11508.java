import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Solution11508 {
    private int n;
    private int[] dairyProducts;

    public Solution11508(int n, int[] dairyProducts) {
        this.n = n;
        this.dairyProducts = dairyProducts;
    }

    public String solve() {
        Arrays.sort(dairyProducts);

        int sum = 0;
        int buyCnt = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(buyCnt == 2) {
                buyCnt = 0;
                continue;
            }

            sum += dairyProducts[i];
            buyCnt++;
        }

        return String.valueOf(sum);
    }
}

public class Problem11508 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(new Solution11508(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
