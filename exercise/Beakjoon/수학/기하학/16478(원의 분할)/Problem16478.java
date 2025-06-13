import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution16478 {
    private int pab;
    private int pbc;
    private int pcd;

    public Solution16478(int pab, int pbc, int pcd) {
        this.pab = pab;
        this.pbc = pbc;
        this.pcd = pcd;
    }

    public String solve() {
        return String.valueOf((double) pab * pcd / pbc);
    }
}

public class Problem16478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw.write(new Solution16478(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())).solve());
        bw.flush();
        bw.close();
    }
}
