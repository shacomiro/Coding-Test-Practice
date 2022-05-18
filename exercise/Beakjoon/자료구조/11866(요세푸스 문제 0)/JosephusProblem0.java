import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JosephusProblem0 {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;
        StringBuilder sb = new StringBuilder("<");

        for(int i = 1; i <= N; i++)
            queue.offer(i);

        while(!queue.isEmpty()) {
            cnt++;

            if(cnt == K) {
                if(queue.size() > 1) sb.append(queue.poll() + ", ");
                else sb.append(queue.poll() + ">");

                cnt = 0;
            } else {
                queue.offer(queue.poll());
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        JosephusProblem0.solution();
    }
}
