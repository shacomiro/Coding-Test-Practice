import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public int solution(String s, String t) {
        int answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        int lt = 0;
        for(int rt = 0; rt < s.length(); rt++) {
            if(rt - lt == t.length()) {
                map.put(s.charAt(lt), map.getOrDefault(s.charAt(lt), 0) + 1);
                if(map.get(s.charAt(lt)) == 0) map.remove(s.charAt(lt));
                lt++;
            }
            map.put(s.charAt(rt), map.getOrDefault(s.charAt(rt), 0) - 1);
            if(map.get(s.charAt(rt)) == 0) map.remove(s.charAt(rt));

            if(map.isEmpty()) answer++;
        }

        return answer;
    }

    public int alternativeSolution(String s, String t) {
        int answer = 0;
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();

        for(char c : t.toCharArray()) mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        for(int i = 0; i < t.length() - 1; i++) mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);

        int lt = 0;
        for(int rt = t.length() -1 ; rt < s.length(); rt++) {
            mapS.put(s.charAt(rt), mapS.getOrDefault(s.charAt(rt), 0) + 1);

            if(mapS.equals(mapT)) answer++;

            mapS.put(s.charAt(lt), mapS.get(s.charAt(lt)) - 1);
            if(mapS.get(s.charAt(lt)) == 0) mapS.remove(s.charAt(lt));
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        System.out.println(T.alternativeSolution(s, t));
    }
}
