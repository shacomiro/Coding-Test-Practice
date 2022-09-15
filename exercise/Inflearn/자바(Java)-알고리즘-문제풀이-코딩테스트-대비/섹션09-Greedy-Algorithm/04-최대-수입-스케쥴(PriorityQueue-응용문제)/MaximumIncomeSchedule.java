import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Lecture implements Comparable<Lecture> {
    public int income;
    public int limit;

    public Lecture(int income, int limit) {
        this.income = income;
        this.limit = limit;
    }

    @Override
    public int compareTo(Lecture o) {
        return this.income - o.income;
    }
}

public class Main {
    static int n;
    static int max = Integer.MIN_VALUE;

    public int solution(int n, ArrayList<Lecture> arr) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr);

        int j = 0;
        for(int i = max; i >= 1; i--) {
            for(; j < n; j++) {
                if(arr.get(j).limit < i) break;
                else pq.offer(arr.get(j).income);
            }

            if(!pq.isEmpty()) answer += pq.poll();
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ArrayList<Lecture> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            arr.add(new Lecture(m, d));
            if(d > max) max = d;
        }

        System.out.println(T.solution(n, arr));
    }
}
