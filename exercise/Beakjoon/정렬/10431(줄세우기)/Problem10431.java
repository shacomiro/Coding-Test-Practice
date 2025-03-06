import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution10431 {
    private int t;
    private int[] kids;

    public Solution10431(int t, int[] kids) {
        this.t = t;
        this.kids = kids;
    }

    public String solve() {
        return String.valueOf(t + " " + insertionSort(kids));
    }

    private int insertionSort(int[] elements) {
        int backwardCnt = 0;
        int j = 0;
        int key = 0;

        for(int i = 1; i < elements.length; i++) {
            key = elements[i];

            for(j = i - 1; j >= 0 && elements[j] > key; j--) {
                elements[j + 1] = elements[j];
                backwardCnt++;
            }
            elements[j + 1] = key;
        }
        
        return backwardCnt;
    }
}

public class Problem10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int[] arr = new int[20];
            for(int j = 0; j < 20; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            bw.write(new Solution10431(t, arr).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
