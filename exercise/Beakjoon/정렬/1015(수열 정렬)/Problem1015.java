import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution1015 {
    private int size;
    private int[] a;
    private int[] b;

    public Solution1015(int size, int[] a) {
        this.size = size;
        this.a = a;
        this.b = getCloneAndSort(a);
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(a[i] == b[j]) {
                    sb.append(j).append(" ");
                    b[j] = 0;
                    
                    break;
                }
            }
        }

        return sb.toString();
    }

    private int[] getCloneAndSort(int[] arr) {
        int[] clone = arr.clone();
        Arrays.sort(clone);

        return clone;
    }
}

public class Problem1015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution1015(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
