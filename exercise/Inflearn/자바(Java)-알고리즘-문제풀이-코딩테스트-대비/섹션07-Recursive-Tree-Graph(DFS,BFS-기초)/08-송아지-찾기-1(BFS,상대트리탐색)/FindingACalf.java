import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public void BFS(int s, int e) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> visit = new ArrayList<>();
        queue.offer(s);
        visit.add(s);
        int jump = 0;

        while(!queue.isEmpty()) {
            int len = queue.size();

            for(int i = 0; i < len; i++) {
                int tmp = queue.poll();

                if(tmp == e) {
                    System.out.println(jump);
                    return;
                }

                if(!visit.contains(tmp - 1)) {
                    visit.add(tmp - 1);
                    queue.offer(tmp - 1);
                }
                if(!visit.contains(tmp + 1)) {
                    visit.add(tmp + 1);
                    queue.offer(tmp + 1);
                }
                if(!visit.contains(tmp + 5)) {
                    visit.add(tmp + 5);
                    queue.offer(tmp + 5);
                }
            }

            jump++;
        }
    }

    int answer = 0;
    int[] dis = {1, -1, 5};
    int[] ch;
    Queue<Integer> Q = new LinkedList<>();

    public int BFS(int s, int e) {
        ch = new int[10001];
        ch[s] = 1;
        Q.offer(s);
        int L = 0;

        while(!Q.isEmpty()) {
            int len = Q.size();

            for(int i = 0; i < len; i++) {
                int x = Q.poll();

//                if(x == e) return L;

                for(int j = 0; j < 3; j++) {
                    int nx = x + dis[j];

                    if(nx == e) return L + 1;
                    if(1 <= nx && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }

            L++;
        }

        return L;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        T.bfs(s, e);
        System.out.println(T.BFS(s, e));
    }
}
