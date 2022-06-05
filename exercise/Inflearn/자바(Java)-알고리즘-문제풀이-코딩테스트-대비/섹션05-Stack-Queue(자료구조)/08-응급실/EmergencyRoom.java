import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int m, int[] dangers) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        int target = m;
        int cnt = 0;

        for(int i : dangers) queue.offer(i);

        while(!queue.isEmpty()) {
            int currDanger = queue.poll();
            boolean priority = true;

            for(int i = 0; i < queue.size(); i++) {
                int danger = queue.poll();

                if(danger > currDanger) priority = false;

                queue.offer(danger);
            }

            if(!priority) queue.offer(currDanger);
            else {
                cnt++;

                if(target == 0) {
                    answer = cnt;
                    break;
                }
            }

            target = target == 0 ? queue.size() - 1 : target - 1;
        }

        return answer;
    }

    class Person {
        private int id;
        private int prioirty;
        
        public Person(int id, int prioirty) {
            this.id = id;
            this.prioirty = prioirty;
        }
        
        public int getId() {
            return id;
        }
        
        public int getPrioirty() {
            return prioirty;
        }
    }

    public int alternativeSolution(int n, int m, int[] dangers) {
        int answer = 0;
        Queue<Person> queue = new LinkedList<>();
        
        for(int i = 0; i < n; i++) queue.offer(new Person(i, dangers[i]));
        
        while(!queue.isEmpty()) {
            Person p = queue.poll();
            
            for(Person x : queue) {
                if(x.getPrioirty() > p.getPrioirty()) {
                    queue.offer(p);
                    p = null;
                    break;
                }
            }
            if(p != null) {
                answer++;
                if(p.getId() == m) return answer;

            }
        }
        
        return answer;
    }


    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int[] dangers = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) dangers[i] = Integer.parseInt(st2.nextToken());

        System.out.println(T.solution(n, m, dangers));
    }
}
