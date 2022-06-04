import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int k) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;

        for(int i = 1; i <= n; i++) queue.offer(i);

        while(queue.size() > 1) {
            int prince = queue.poll();

            if(queue.isEmpty()) answer = prince;
            cnt++;

            if(cnt != k) queue.offer(prince);
            else cnt = 0;
        }

        return answer;
    }

    public int alternativeSolution(int n, int k) {
        int answer = 0;
        Queue<Integer> Q = new LinkedList<>();

        for(int i = 1; i <= n; i++) Q.offer(i);

        while(!Q.isEmpty()) {
            for(int i = 0; i < k; i++) Q.offer(Q.poll());
            
            Q.poll();
            if(Q.size() == 1) answer = Q.poll();
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(T.solution(n, k));
    }
}
