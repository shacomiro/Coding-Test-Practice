import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution1654 {
    private int required;
    private int[] lanCables;

    public Solution1654(int required, int[] lanCables) {
        this.required = required;
        this.lanCables = lanCables;
    }

    public String solve() {
        return String.valueOf(binarySearch(lanCables, 1, getMax(lanCables)));
    }

    private int getMax(int[] arr) {
        int max = 0;

        for(int n : arr) {
            if(max < n) {
                max = n;
            }
        }

        return max;
    }

    private int binarySearch(int[] elements, long lt, long rt) {
        int found = 0;

        while(lt <= rt) {
            long mid = (lt + rt) / 2;
            long sum = 0;

            for(int e : elements) {
                sum += e / mid;
            }

            if(sum < required) {
                rt = mid - 1;
            } else {
                found = (int) mid;
                lt = mid + 1;
            }
        }

        return found;
    }
}

public class Problem1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        for(int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(new Solution1654(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
