import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution2920 {
    private int[] scales;

    public Solution2920(int[] scales) {
        this.scales = scales;
    }

    public String solve() {
        boolean isAscending = false;
        boolean isDescending = false;

        for(int i = 0; i < 7; i++) {
            if(scales[i] < scales[i + 1]) {
                isAscending = true;
            } else {
                isDescending = true;
            }
        }

        return (isAscending && isDescending) ? "mixed" : isAscending ? "ascending" : "descending";
    }
}

public class Problem2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[8];
        for(int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution2920(arr).solve());
        bw.flush();
        bw.close();
    }
}
