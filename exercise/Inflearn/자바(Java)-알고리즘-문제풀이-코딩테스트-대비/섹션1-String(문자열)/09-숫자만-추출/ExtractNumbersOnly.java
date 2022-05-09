import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public int solution(String str) {
        return Integer.parseInt(str.replaceAll("[^0-9]", ""));
    }

    public int alternativeSolutionOne(String str) {
        int answer = 0;

        for(char c : str.toCharArray()) {
            if(48 <= c && c <= 57)
                answer = answer * 10 + (c - 48);
        }

        return answer;
    }

    public int alternativeSolutionTwo(String str) {
        StringBuilder answer = new StringBuilder();

        for(char c : str.toCharArray()) {
            if(Character.isDigit(c))
                answer.append(c);
        }

        return Integer.parseInt(answer.toString());
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(T.solution(str));
    }
}
