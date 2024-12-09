import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution32748 {
    private int[] fx;
    private int[] y;
    private String fa;
    private String fb;

    public Solution32748(int[] fx, int[] y, String fa, String fb) {
        this.fx = fx;
        this.y = y;
        this.fa = fa;
        this.fb = fb;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        for(char cFa : fa.toCharArray()) {
            sb.append(y[cFa - 48]);
        }
        int a = Integer.valueOf(sb.toString());
        sb = new StringBuilder();
        for(char cFb : fb.toCharArray()) {
            sb.append(y[cFb  - 48]);
        }
        int b = Integer.valueOf(sb.toString());

        int ab = a + b;
        sb = new StringBuilder();
        for(char cAb : String.valueOf(ab).toCharArray()) {
            sb.append(fx[cAb  - 48]);
        }

        return sb.toString();
    }
}

public class Problem32748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        for(int x = 0; x < 10; x++) {
            int y = Integer.parseInt(st.nextToken());
            arr1[x] = y;
            arr2[y] = x;
        }
        st = new StringTokenizer(br.readLine());
        String fa = st.nextToken();
        String fb = st.nextToken();

        bw.write(new Solution32748(arr1, arr2, fa, fb).solve());
        bw.flush();
        bw.close();
    }
}
