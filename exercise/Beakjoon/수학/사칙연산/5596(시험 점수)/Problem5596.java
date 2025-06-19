import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution5596 {
    private int[] minguk;
    private int[] manse;

    public Solution5596(int[] minguk, int[] manse) {
        this.minguk = minguk;
        this.manse = manse;
    }

    public String solve() {
        int mingukSum = 0;
        int manseSum = 0;

        for (int i = 0; i < 4; i++) {
            mingukSum += minguk[i];
            manseSum += manse[i];
        }

        return String.valueOf(Math.max(mingukSum, manseSum));
    }
}

public class Problem5596 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[4];
        for (int i = 0; i < 4; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] arr2 = new int[4];
        for (int i = 0; i < 4; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution5596(arr1, arr2).solve());
        bw.flush();
        bw.close();
    }
}
