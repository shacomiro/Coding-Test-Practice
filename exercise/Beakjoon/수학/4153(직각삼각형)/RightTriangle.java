import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RightTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        int[] side = new int[3];

        while(!(input = br.readLine()).equals("0 0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            for(int i = 0; i < 3; i++) {
                side[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(side);
            if(side[0] * side[0] + side[1] * side[1] == side[2] * side[2]) {
                bw.write("right");
            } else {
                bw.write("wrong");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}