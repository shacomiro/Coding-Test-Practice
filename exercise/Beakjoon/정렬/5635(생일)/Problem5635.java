import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Solution5635 {
    private SortedSet<Person> set;

    public Solution5635(List<Person> people) {
        this.set = new TreeSet<>(people);
    }
    
    public String solve() {
        return new StringBuilder()
                .append(set.first().getName())
                .append("\n")
                .append(set.last().getName())
                .toString();
    }
    
    static class Person implements Comparable<Person> {
        private String name;
        private int year;
        private int month;
        private int day;

        public Person(String name, int day, int month, int year) {
            this.name = name;
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Person o) {
            if(this.year != o.year) {
                return o.year - this.year;
            }

            if(this.month != o.month) {
                return o.month - this.month;
            }

            return o.day - this.day;
        }
    }
}

public class Problem5635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Solution5635.Person> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(
                new Solution5635.Person(st.nextToken(),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()))
                );
        }

        bw.write(new Solution5635(list).solve());
        bw.flush();
        bw.close();
    }
}
