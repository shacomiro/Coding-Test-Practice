import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
  
public class Main {
  public StringBuilder solution(String str) {
        StringBuilder answer = new StringBuilder();

        for(char c : str.toCharArray()) {
            if(Character.isUpperCase(c))
                answer.append(Character.toLowerCase(c));
            else
                answer.append(Character.toUpperCase(c));
        }

        return answer;
    }

    public StringBuilder alternativeSolution(String str) {
        StringBuilder answer = new StringBuilder();

        // char 자료형의 ASCII 코드값을 직접 비교, 연산하는 방법도 가능하다.
        for(char c : str.toCharArray()) {
            if(c >= 65 && c <= 90)
                answer.append((char) (c + 32));
            else
                answer.append((char) (c - 32));
        }

        return answer;
    }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    Main main = new Main();

    System.out.println(main.solution(str));
  }
}