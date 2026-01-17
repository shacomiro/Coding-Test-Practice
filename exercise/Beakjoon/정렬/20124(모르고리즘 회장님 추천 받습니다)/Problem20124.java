import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem20124 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Solver.Person> list1 = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list1.add(new Solver.Person(st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        bw.write(new Solver(n, list1).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private List<Person> persons;

        public Solver(int n, List<Person> persons) {
            this.n = n;
            this.persons = persons;
        }

        public String solve() {
            Collections.sort(persons);

            return persons.get(0).getName();
        }

        private static class Person implements Comparable<Person> {
            private String name;
            private int score;

            public Person(String name, int score) {
                this.name = name;
                this.score = score;
            }

            public String getName() {
                return name;
            }

            public int getScore() {
                return score;
            }

            @Override
            public int compareTo(Person o) {
                return (o.getScore() == this.getScore()) ? this.getName().compareTo(o.getName())
                        : Integer.compare(o.getScore(), this.getScore());
            }
        }
    }
}
