import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem15650 {
    private static StringBuffer answer;

    public static String solution(int n, int m) {
        answer = new StringBuffer();
        int[] numbers = new int[n];
        for(int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }

        combination(numbers, new boolean[n], 0, 0, n, m);

        return answer.toString();
    }

    private static void combination(int[] elements, boolean[] isSelected, int start, int depth, int n, int r) {
        if(r == 0) {
            appendCombinationToAnswer(elements, isSelected);

            return;
        }

        for(int i = start; i < n; i++) {
            if(isSelected[i]) {
                continue;
            }

            isSelected[i] = true;
            combination(elements, isSelected, i + 1, depth + 1, n, r - 1);
            isSelected[i] = false;
        }
    }

    private static void appendCombinationToAnswer(int[] elements, boolean[] isSelected) {
        for(int i = 0; i < isSelected.length; i++) {
            if(isSelected[i]) {
                answer.append(elements[i]).append(" ");
            }
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
