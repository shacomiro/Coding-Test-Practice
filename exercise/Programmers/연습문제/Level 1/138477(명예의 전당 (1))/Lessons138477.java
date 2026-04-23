import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Lessons138477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(Arrays.toString(new Solution().solution(k, arr)));
        bw.flush();
        bw.close();
    }

    static class Solution {
        public int[] solution(int k, int[] score) {
            int[] answer = new int[score.length];
            // 기본적으로 최소 힙(Min-Heap)으로 동작.
            PriorityQueue<Integer> hallOfFame = new PriorityQueue<>();

            for (int i = 0; i < score.length; i++) {
                hallOfFame.add(score[i]);

                // 명예의 전당의 크기가 k를 초과하면 가장 작은 값(최하위 점수)을 제거
                if (hallOfFame.size() > k) {
                    hallOfFame.poll();
                }

                // 현재 명예의 전당에서 가장 작은 값(최하위 점수)을 기록
                answer[i] = hallOfFame.peek();
            }

            return answer;
        }
    }
}
