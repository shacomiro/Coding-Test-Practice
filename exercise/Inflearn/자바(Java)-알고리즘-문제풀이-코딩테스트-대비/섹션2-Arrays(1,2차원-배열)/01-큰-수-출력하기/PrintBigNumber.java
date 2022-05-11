package section2.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public ArrayList<Integer> solution(int n, int[] numbers) {
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0; i < numbers.length; i++)
            if(i == 0 || (numbers[i] > numbers[i - 1])) answer.add(numbers[i]);

        return answer;
    }
    // Times: 110ms, Memory: 26MB

    public ArrayList<Integer> alternativeSolution(int n, int[] numbers) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(numbers[0]);

        for(int i = 1; i < n; i++) {
            if(numbers[i] > numbers[i - 1]) answer.add(numbers[i]);
        }

        return answer;
    }
    // Times: 109ms, Memory: 26MB

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int[] numbers = new int[target];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < target; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for(int n : T.solution(target, numbers)) {
            System.out.print(n + " ");
        }
    }
}
