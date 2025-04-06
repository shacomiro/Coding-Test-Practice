import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Solution14911 {
    private List<Integer> numbers;
    private int x;
    private Set<Pair> pairs;

    public Solution14911(List<Integer> numbers, int x) {
        this.numbers = numbers;
        this.x = x;
        this.pairs = new TreeSet<>();
    }

    public String solve() {
        Collections.sort(numbers);

        for(int i = 0; i < numbers.size(); i++) {
            for(int j = i + 1; j < numbers.size(); j++) {
                int numA = numbers.get(i);
                int numB = numbers.get(j);

                if(numA + numB == x) {
                    pairs.add(new Pair(numA, numB));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Pair p : pairs) {
            sb.append(p.toString()).append("\n");
        }
        sb.append(pairs.size());

        return sb.toString();
    }

    static class Pair implements Comparable<Pair> {
        private int numberA;
        private int numberB;

        public Pair(int numberA, int numberB) {
            this.numberA = numberA;
            this.numberB = numberB;
        }

        @Override
        public String toString() {
            return numberA + " " + numberB;
        }

        @Override
        public int compareTo(Solution14911.Pair o) {
            return (this.numberA == o.numberA) ? Integer.compare(this.numberB, o.numberB) : Integer.compare(this.numberA, o.numberA);
        }
    }
}

public class Problem14911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>(10);
        while(st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int x = Integer.parseInt(br.readLine());

        bw.write(new Solution14911(list, x).solve());
        bw.flush();
        bw.close();
    }
}
