import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

class Solution15733 {
    public String solve() {
        return "I'm Sexy";
    }
}

public class Problem15733 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution15733().solve());
        bw.flush();
        bw.close();
    }
}
