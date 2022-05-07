import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public int solution(String str, char target) {
        int answer = 0;
        String string = str.toUpperCase();
        char c = Character.toUpperCase(target);

        for(char charOfstr : string.toCharArray()) {
            if(charOfstr == c) answer++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char c = br.readLine().charAt(0);

        System.out.println(main.solution(str, c));
    }
}