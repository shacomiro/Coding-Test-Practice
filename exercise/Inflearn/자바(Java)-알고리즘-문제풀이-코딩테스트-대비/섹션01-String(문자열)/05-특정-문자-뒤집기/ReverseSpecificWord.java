import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public String solution(String str) {
        String answer;
        char[] s = str.toCharArray();
        int lt = 0;
        int rt = s.length - 1;

        while(lt < rt) {
            boolean lCheck = Character.isAlphabetic(s[lt]);
            boolean rCheck = Character.isAlphabetic(s[rt]);

            if(!lCheck) {
                lt++;
            } else if(!rCheck) {
                rt--;
            } else {
                char temp = s[lt];
                s[lt] = s[rt];
                s[rt] = temp;

                lt++;
                rt--;
            }
        }

        answer = String.valueOf(s);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(T.solution(str));
    }
}
