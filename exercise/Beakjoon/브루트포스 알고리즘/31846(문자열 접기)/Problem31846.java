import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution31846 {
    private int n;
    private String s;
    private int l;
    private int r;

    public Solution31846(int n, String s, int l, int r) {
        this.n = n;
        this.s = s;
        this.l = l;
        this.r = r;
    }

    public String solve() {
        String paper = s.substring(l - 1, r);
        int maxPoint = 0;

        for (int i = 0; i < paper.length(); i++) {
            int li = i;
            int ri = i + 1;
            int currPoint = 0;

            while (li >= 0 && ri < paper.length()) {
                if (paper.charAt(li) == paper.charAt(ri)) {
                    currPoint++;
                }

                li--;
                ri++;
            }

            maxPoint = Math.max(maxPoint, currPoint);
        }

        return String.valueOf(maxPoint);
    }
}

public class Problem31846 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            bw.write(new Solution31846(n, s, l, r).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
