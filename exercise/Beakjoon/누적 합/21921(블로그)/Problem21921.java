import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution21921 {
    private int[] visitInfo;
    private int size;
    private int days;
    private int max;
    private int count;

    public Solution21921(int size, int days, int[] visitInfo) {
        this.visitInfo = visitInfo;
        this.size = size;
        this.days = days;
        this.max = 0;
        this.count = 0;
    }

    public String solve() {
        check();

        StringBuilder sb = new StringBuilder();
        if(max > 0) {
            sb.append(max).append("\n").append(count);
        } else {
            sb.append("SAD");
        }

        return sb.toString();
    }

    private void check() {
        int start = 0;
        int end = start + days - 1;
        int sum = 0;

        for(int i = start; i <= end; i++) {
            sum += visitInfo[i];
        }
        if(max < sum) {
            max = sum;
            count = 1;
        }

        while(end < size - 1) {
            end++;
            sum = sum + visitInfo[end] - visitInfo[start];
            start++;

            if(max < sum) {
                max = sum;
                count = 1;
            } else if(max == sum) {
                count++;
            }
        }
    }
}

public class Problem21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution21921(n, x, arr).solve());
        bw.flush();
        bw.close();
    }
}
