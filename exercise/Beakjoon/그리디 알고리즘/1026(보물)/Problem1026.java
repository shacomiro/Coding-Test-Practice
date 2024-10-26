import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Solution1026 {
    private int size;
    private Integer[] arrA;
    private Integer[] arrB;

    public Solution1026(int size, Integer[] arrA, Integer[] arrB) {
        this.size = size;
        this.arrA = arrA;
        this.arrB = arrB;
    }

    public String solve() {
        Arrays.sort(arrA);
        Arrays.sort(arrB, Collections.reverseOrder());

        int sum = 0;
        for(int i = 0; i < size; i++) {
            sum += arrA[i] * arrB[i];
        }

        return String.valueOf(sum);
    }
}

public class Problem1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Integer[] arr1 = new Integer[n];
        Integer[] arr2 = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());    
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());    
        }

        bw.write(new Solution1026(n, arr1, arr2).solve());
        bw.flush();
        bw.close();
    }
}
