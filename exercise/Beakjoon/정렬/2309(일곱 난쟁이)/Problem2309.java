import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Problem2309 {
    public static ArrayList<Integer> solution(ArrayList<Integer> list) {
        int sum = 0;
        for(int x : list) sum += x;
        int target = sum - 100;
        int dwf1 = 0;
        int dwf2 = 0;

        findFakeDwarf:
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++) {
                if(i == j) continue;

                dwf1 = list.get(i);
                dwf2 = list.get(j);

                if(dwf1 + dwf2 == target) break findFakeDwarf;
            }

        list.remove((Integer) dwf1);
        list.remove((Integer) dwf2);
        Collections.sort(list);

        return list;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 9; i++) list.add(Integer.parseInt(br.readLine()));
        br.close();

        for(int x : solution(list)) System.out.println(x);
    }
}