import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public int[] solution(String str, char t) {
        int[] answer = new int[str.length()];
        char[] s = str.toCharArray();

        for(int i = 0; i < s.length; i++) {
            if(s[i] == t)
                s[i] = '0';
        }

        int idx = 0;
        int targetDistance = 0;
        boolean searchChar = true;
        boolean findChar = false;

        while(searchChar) {
            if(s[idx] == (char) (targetDistance + 48)) {
                if(0 <= idx - 1 && Character.isAlphabetic(s[idx - 1])) {
                    findChar = true;
                    s[idx - 1] = (char) (targetDistance + 48 + 1);
                }
                if(idx + 1 <= s.length - 1 && Character.isAlphabetic(s[idx + 1])) {
                    findChar = true;
                    s[idx + 1] = (char) (targetDistance + 48 + 1);
                }
            }

            idx++;

            if(idx == s.length) {
                if(!findChar)
                    searchChar = false;

                idx = 0;
                targetDistance += 1;
                findChar = false;
            }
        }

        for(int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(String.valueOf(s[i]));
        }

        return answer;
    }
    // Time: 108ms, Memory: 26MB

    public int[] alternativeSolution(String str, char t) {
        int[] answer = new int[str.length()];
        int p = 99;

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == t)
                p = 0;
            else
                p++;

            answer[i] = p;
        }

        for(int i = str.length() - 1; i >= 0; i--) {
            if(str.charAt(i) == t)
                p = 0;
            else
                p++;

            answer[i] = Math.min(answer[i], p);
        }

        return answer;
    }
    // Time: 121ms, Memory: 26MB

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int num : T.solution(st.nextToken(), st.nextToken().charAt(0))) {
            System.out.print(num + " ");
        }
    }
}
