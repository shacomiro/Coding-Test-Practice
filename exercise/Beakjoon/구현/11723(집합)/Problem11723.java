import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution11723 {
    private BufferedReader br;
    private int bitSet;

    public Solution11723() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.bitSet = 0;
    }

    public String solve() throws IOException {
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            int number = -1;

            switch (operation) {
                case "add":
                    number = Integer.parseInt(st.nextToken());
                    bitSet |= (1 << number - 1);
                    break;
                case "remove":
                    number = Integer.parseInt(st.nextToken());
                    bitSet &= ~(1 << number - 1);
                    break;
                case "check":
                    number = Integer.parseInt(st.nextToken());
                    sb.append((bitSet & (1 << number - 1)) == 0 ? 0 : 1).append("\n");
                    break;
                case "toggle":
                    number = Integer.parseInt(st.nextToken());
                    bitSet ^= (1 << number - 1);
                    break;
                case "all":
                    bitSet = (1 << 20) - 1;
                    break;
                case "empty":
                    bitSet = 0;
                    break;
            }
        }

        return sb.toString();
    }
}

public class Problem11723 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution11723().solve());
        bw.flush();
        bw.close();
    }
}
