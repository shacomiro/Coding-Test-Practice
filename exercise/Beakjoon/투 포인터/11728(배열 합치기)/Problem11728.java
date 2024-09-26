import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution11728 {
    private int[] arrA;
    private int[] arrB;
    private int[] arrC;

    public Solution11728(int[] arrA, int[] arrB) {
        this.arrA = arrA;
        this.arrB = arrB;
        this.arrC = new int[arrA.length + arrB.length];
    }

    public String solve() {
        int pa = 0;
        int pb = 0;
        int idx = 0;

        while(pa < arrA.length && pb < arrB.length) {
            arrC[idx++] = (arrA[pa] <= arrB[pb]) ? arrA[pa++] : arrB[pb++];
        }
        
        while(pa < arrA.length) {
            arrC[idx++] = arrA[pa++];
        }
        
        while(pb < arrB.length) {
            arrC[idx++] = arrB[pb++];
        }

        StringBuilder sb = new StringBuilder();
        for(int n : arrC) {
            sb.append(n).append(" ");
        }

        return sb.toString();
    }
}

public class Problem11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution11728(arr1, arr2).solve());
        bw.flush();
        bw.close();
    }
}
