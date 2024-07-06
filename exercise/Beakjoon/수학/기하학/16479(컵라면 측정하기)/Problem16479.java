import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution16479 {
    private int inclinedPlane;
    private int upperDiameter;
    private int lowerDiameter;

    public Solution16479(int inclinedPlane, int upperDiameter, int lowerDiameter) {
        this.inclinedPlane = inclinedPlane;
        this.upperDiameter = upperDiameter;
        this.lowerDiameter = lowerDiameter;
    }

    public String solve() {
        double a = (upperDiameter - lowerDiameter) / 2.0;
        double c = inclinedPlane;

        return String.valueOf((c * c) - (a * a));
    }
}

public class Problem16479 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int d1 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        bw.write(new Solution16479(k, d1, d2).solve());
        bw.flush();
        bw.close();
    }
}
