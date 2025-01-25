import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution1817 {
    private int n;
    private int m;
    private int[] books;

    public Solution1817(int n, int m, int[] books) {
        this.n = n;
        this.m = m;
        this.books = books;
    }

    public String solve() {
        if(n == 0) {
            return "0";
        }

        int cnt = 1;
        int empty = m;

        for(int i = 0; i < n; i++) {
            if(empty - books[i] >= 0) {
                empty -= books[i];
            } else {
                cnt++;
                empty = m - books[i];
            }
        }

        return String.valueOf(cnt);
    }
}

public class Problem1817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        if(n > 0) {
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(new Solution1817(n, m, arr).solve());
        bw.flush();
        bw.close();
    }   
}
