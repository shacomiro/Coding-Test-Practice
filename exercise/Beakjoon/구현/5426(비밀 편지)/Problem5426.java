import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution5426 {
    private String letter;
    private int size;
    private char[][] letterPaper;

    public Solution5426(String letter) {
        this.letter = letter;
        this.size = (int) Math.sqrt(letter.length());
        this.letterPaper = new char[size][size];
    }

    public String solve() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                letterPaper[i][j] = letter.charAt(i * size + j);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = size - 1; i >= 0; i--) {
            for(int j = 0; j < size; j++) {
                sb.append(letterPaper[j][i]);
            }
        }

        return sb.toString();
    }
}
public class Problem5426 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            bw.write(new Solution5426(br.readLine()).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
