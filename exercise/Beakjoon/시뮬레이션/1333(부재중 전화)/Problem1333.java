import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution1333 {
    private int n;
    private int l;
    private int d;

    public Solution1333(int n, int l, int d) {
        this.n = n;
        this.l = l;
        this.d = d;
    }

    public String solve() {    
        int albumTime = n * l + (n - 1) * 5;
        int ringTime = 0;
        int cycle = l + 5;

        while(ringTime < albumTime) {
            if(ringTime % cycle >= l) {
                break;
            }

            ringTime += d;
        }

        return String.valueOf(ringTime);
    }
}

public class Problem1333 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        bw.write(new Solution1333(n, l, d).solve());
        bw.flush();
        bw.close();
    }
}
