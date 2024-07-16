import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Solution24511 {
    private ArrayDeque<Integer> queuestack;
    private int[] addElements;

    public Solution24511(int[] types, int[] initialElements, int[] addElements) {
        this.queuestack = new ArrayDeque<>();
        this.addElements = addElements;

        for(int i = 0; i < initialElements.length; i++) {
            if(types[i] == 0) {
                queuestack.addLast(initialElements[i]);
            }
        }
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < addElements.length; i++) {
            queuestack.addFirst(addElements[i]);
            sb.append(queuestack.pollLast()).append(" ");
        }

        return sb.toString();
    }
}

public class Problem24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] arr3 = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            arr3[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution24511(arr1, arr2, arr3).solve());
        bw.flush();
        bw.close();
    }
}
