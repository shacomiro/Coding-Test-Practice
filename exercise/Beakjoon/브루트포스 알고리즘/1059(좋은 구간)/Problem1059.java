import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution1059 {
    private int l;
    private int[] numbers;
    private int n;

    public Solution1059(int l, int[] numbers, int n) {
        this.l = l;
        this.numbers = numbers;
        this.n = n;
    }

    public String solve() {
        Arrays.sort(numbers);

        int lt = 1;
        int rt = numbers[l - 1];
        for(int i = 0; i < l; i++) {
            if(numbers[i] < n) {
                lt = numbers[i] + 1;
            } else if (numbers[i] > n) {
                rt = numbers[i] - 1;
                break;
            } else {
                return String.valueOf(0);
            }
        }

        int cnt = 0;
        for(int a = lt; a < rt; a++) {
            for(int b = a + 1; b <= rt; b++) {
                if(a <= n && n <= b) {
                    cnt++;
                }
            }
        }

        return String.valueOf(cnt);
    }
}

public class Problem1059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int l = Integer.parseInt(br.readLine());
        int[] arr = new int[l];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < l; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int n = Integer.parseInt(br.readLine());

        bw.write(new Solution1059(l, arr, n).solve());
        bw.flush();
        bw.close();
    }
}
