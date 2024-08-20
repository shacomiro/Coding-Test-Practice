import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution2805 {
    private int[] trees;
    private int target;

    public Solution2805(int[] trees, int target) {
        this.trees = trees;
        this.target = target;
    }

    public String solve() {
        return String.valueOf(binarySearch(trees, 0, getMax(trees)));
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

    private int binarySearch(int[] elements, int lt, int rt) {
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            long sum = 0;

            for(int e : elements) {
                int gap = e - mid;

                if(gap > 0) {
                    sum += gap;
                }
            }

            if(sum < target) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return lt - 1;
    }
}

public class Problem2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution2805(arr, m).solve());
        bw.flush();
        bw.close();
    }
}
