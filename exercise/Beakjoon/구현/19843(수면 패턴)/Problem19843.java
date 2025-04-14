import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution19843 {
    private final static String[] DOW = {"Mon", "Tue", "Wed", "Thu", "Fri"};
    private int t;
    private int n;
    private String[] sleeps;

    public Solution19843(int t, int n, String[] sleeps) {
        this.t = t;
        this.n = n;
        this.sleeps = sleeps;
    }

    public String solve() {
        StringTokenizer st;
        int sleepTime = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(sleeps[i]);
            String d1 = st.nextToken();
            int h1 = Integer.parseInt(st.nextToken());
            String d2 = st.nextToken();
            int h2 = Integer.parseInt(st.nextToken());
            
            if(d1.equals(d2)) {
                sleepTime += h2 - h1;
            } else {
                int d1i = -1;
                int d2i = -1;

                for(int j = 0; j < 5; j++) {
                    if(d1.equals(DOW[j])) {
                        d1i = j;
                    }
                    if(d2.equals(DOW[j])) {
                        d2i = j;
                    }
                }
    
                sleepTime += (24 * (d2i - d1i)) - h1 + h2;
            }
        }

        return (sleepTime >= t) ? "0" : (sleepTime + 48 < t) ? "-1" : String.valueOf(t - sleepTime);
    }
}

public class Problem19843 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        bw.write(new Solution19843(t, n, arr).solve());
        bw.flush();
        bw.close();
    }
}
