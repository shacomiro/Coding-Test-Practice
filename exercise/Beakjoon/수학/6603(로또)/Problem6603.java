import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem6603 {
    private static StringBuilder answer;

    public static String solution(int k, int[] s) {
        answer = new StringBuilder();
        combination(s, new boolean[k], 0, k, 6);

        return answer.toString();
    }

    private static void combination(int[] elements, boolean[] selected, int depth, int n, int r) {
        if(r == 0) {
            writeCombi(elements, selected, n);
            return;
        }

        for(int i = depth; i < n; i++) {
            selected[i] = true;
            combination(elements, selected, i + 1, n, r - 1);
            selected[i] = false;
        }   
    }

    private static void writeCombi(int[] elements, boolean[] selected, int n) {
        for(int i = 0; i < n; i++) {
            if(selected[i]) {
                answer.append(elements[i]).append(" ");
            }
        }
        answer.append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        while(!(input = br.readLine()).equals("0")) {
            StringTokenizer st = new StringTokenizer(input);
            int k = Integer.parseInt(st.nextToken());
            int[] s = new int[k];

            for(int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }

            bw.write(solution(k, s));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}