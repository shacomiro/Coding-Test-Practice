import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Honeycomb {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int holes = 1;
        int level = 1;
        while(n > holes) {
            holes += 6 * level;
            level++;
        }

        bw.write(String.valueOf(level));
        bw.flush();
        bw.close();
    }
}
