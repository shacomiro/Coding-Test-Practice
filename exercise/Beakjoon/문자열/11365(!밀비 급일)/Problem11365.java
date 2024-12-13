import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

class Solution11365 {
    private List<StringBuilder> passphrases;

    public Solution11365(List<StringBuilder> passphrases) {
        this.passphrases = passphrases;
    }

    public String solve() {
        StringBuilder decryption = new StringBuilder();

        for(StringBuilder p : passphrases) {
            decryption.append(p.reverse()).append("\n");
        }

        return decryption.toString();
    }
}

public class Problem11365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;

        List<StringBuilder> list = new ArrayList<>();
        while(!(input = br.readLine()).equals("END")) {
            list.add(new StringBuilder(input));
        }

        bw.write(new Solution11365(list).solve());
        bw.flush();
        bw.close();
    }
}
