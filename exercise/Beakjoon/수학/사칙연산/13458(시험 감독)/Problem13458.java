import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution13458 {
    private List<Integer> examPlace;
    private int inspector;
    private int viceInspector;

    public Solution13458(List<Integer> examPlace, int inspector, int viceInspector) {
        this.examPlace = examPlace;
        this.inspector = inspector;
        this.viceInspector = viceInspector;
    }

    public String solve() {
        long count = 0;

        for(int ep : examPlace) {
            ep -= inspector;
            count++;

            if(ep > 0) {
                int quotient = ep / viceInspector;
                int remainder = ep % viceInspector;
                count += remainder == 0 ? quotient : quotient + 1;
            }
        }

        return String.valueOf(count);
    }
}

public class Problem13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>(n);
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        bw.write(new Solution13458(list, b, c).solve());
        bw.flush();
        bw.close();
    }
}