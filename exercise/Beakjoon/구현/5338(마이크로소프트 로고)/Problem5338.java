import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Problem5338 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write("       _.-;;-._");
        bw.newLine();
        bw.write("'-..-'|   ||   |");
        bw.newLine();
        bw.write("'-..-'|_.-;;-._|");
        bw.newLine();
        bw.write("'-..-'|   ||   |");
        bw.newLine();
        bw.write("'-..-'|_.-''-._|");
        bw.flush();
        bw.close();
    }
}
