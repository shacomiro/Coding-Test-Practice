import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public String solution(int n, String str) {
        String answer = "";
        int max = 0;
        HashMap<String, Integer> hashmap = new HashMap<>();

        for(String sign : str.split("")) {
            hashmap.put(sign, hashmap.getOrDefault(sign, 0) + 1);

            int vote = hashmap.get(sign);
            if(vote > max) {
                max = vote;
                answer = sign;
            }
        }

        return answer;
    }

    public char alternativeSolution(int n, String str) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : str.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int max = Integer.MIN_VALUE;

        for(char key : map.keySet()) {
            if(map.get(key) > max) max = map.get(key);
            answer = key;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        System.out.println(T.solution(n, str));
    }
}
