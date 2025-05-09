import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Solution14469 {
    private int n;
    private int[][] cows;

    public Solution14469(int n, int[][] cows) {
        this.n = n;
        this.cows = cows;
    }

    public String solve() {
        Arrays.sort(cows, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int admissionTime = 0;
        for (int[] cow : cows) {
            admissionTime = ((admissionTime <= cow[0]) ? cow[0] : admissionTime) + cow[1];
        }

        return String.valueOf(admissionTime);
    }
}

public class Problem14469 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution14469(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
