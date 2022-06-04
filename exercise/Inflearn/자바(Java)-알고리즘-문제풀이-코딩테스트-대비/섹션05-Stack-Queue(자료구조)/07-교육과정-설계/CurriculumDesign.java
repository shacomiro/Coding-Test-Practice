import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public String solution(String str1, String str2) {
        String answer = "YES";
        Queue<Character> queue = new LinkedList<>();

        for(char c : str1.toCharArray()) queue.offer(c);

        for(char c : str2.toCharArray()) if(queue.contains(c) && c != queue.poll()) return "NO";

        if(!queue.isEmpty()) return "NO";

        return answer;
    }

    public String alternativeSolution(String need, String plan) {
        String answer = "YES";
        Queue<Character> queue = new LinkedList<>();

        for(char c : need.toCharArray()) queue.offer(c);
        for(char c : plan.toCharArray())
            if(queue.contains(c))
                if(c != queue.poll()) return "NO";

        if(!queue.isEmpty()) return "NO";

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        System.out.println(T.solution(str1, str2));
    }
}
