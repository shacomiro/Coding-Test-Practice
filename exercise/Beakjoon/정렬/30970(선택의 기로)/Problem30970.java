import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Solution30970 {
    private static final Comparator<int[]> qualityFirst = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return (o1[0] != o2[0]) ? Integer.compare(o2[0], o1[0]) : Integer.compare(o1[1], o2[1]);
        }
    };
    private static final Comparator<int[]> priceFirst = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return (o1[1] != o2[1]) ? Integer.compare(o1[1], o2[1]) : Integer.compare(o2[0], o1[0]);
        }
    };

    private int n;
    private int[][] miniatures;

    public Solution30970(int n, int[][] miniatures) {
        this.n = n;
        this.miniatures = miniatures;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(miniatures, qualityFirst);
        sb.append(miniatures[0][0]).append(" ").append(miniatures[0][1]).append(" ")
                .append(miniatures[1][0]).append(" ").append(miniatures[1][1]).append("\n");
        Arrays.sort(miniatures, priceFirst);
        sb.append(miniatures[0][0]).append(" ").append(miniatures[0][1]).append(" ")
                .append(miniatures[1][0]).append(" ").append(miniatures[1][1]);

        return sb.toString();
    }
}

public class Problem30970 {
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

        bw.write(new Solution30970(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
