import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem15651 {
    private static StringBuffer answer;

    public static String solution(int n, int m) {
        answer = new StringBuffer();
        int[] numbers = new int[n];
        for(int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }

        duplicatedPermutation(numbers, new int[m], 0, n, m);

        return answer.toString();
    }

    private static void duplicatedPermutation(int[] elements, int[] current, int depth, int n, int r) {
        if(r == 0) {
            appendPermutationToAnswer(current);

            return;
        }

        for(int i = 0; i < n; i++) {
            current[depth] = elements[i];
            duplicatedPermutation(elements, current, depth + 1, n, r - 1);
        }
    }

    private static void appendPermutationToAnswer(int[] current) {
        for(int i = 0; i < current.length; i++) {
            answer.append(current[i]).append(" ");
        }
        answer.append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        bw.write(solution(n, m));
        bw.flush();
        bw.close();
    }
}
