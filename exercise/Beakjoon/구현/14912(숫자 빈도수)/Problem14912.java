import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution14912 {
    private int number;
    private int target;

    public Solution14912(int number, int target) {
        this.number = number;
        this.target = target;
    }

    public String solve() {
        int count = 0;

        for(int i = 1; i <= number; i++) {
            for(char c : String.valueOf(i).toCharArray()) {
                if(Character.getNumericValue(c) == target) {
                    count++;
                }
            }
        }

        return String.valueOf(count);
    }
}

public class Problem14912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        bw.write(new Solution14912(n, d).solve());
        bw.flush();
        bw.close();
    }
}
