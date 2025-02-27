import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Solution4779 {
    private char[] line;

    public Solution4779(int n) {
        this.line = new char[(int) Math.pow(3, n)];
    }

    public String solve() {
        Arrays.fill(line, '-');
        divide(0, line.length - 1);

        return String.valueOf(line);
    }
    

    private void divide(int start, int end) {
        if(start == end) {
            return;
        }

        int divLength = (end - start + 1) / 3;
        int cut1 = start + divLength;
        int cut2 = end - divLength;

        for(int i = cut1; i <= cut2; i++) {
            line[i] = ' ';
        }

        divide(start, cut1 - 1);
        divide(cut2 + 1, end);
    }
}

public class Problem4779 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;

        while((input = br.readLine()) != null) {
            bw.write(new Solution4779(Integer.parseInt(input)).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
