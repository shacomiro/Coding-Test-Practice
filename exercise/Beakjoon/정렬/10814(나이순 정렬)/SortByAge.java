import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SortByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Person[] people = new Person[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i] = new Person(i, Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Arrays.sort(people);

        for(Person person : people) {
            bw.write(person.toString());
            bw.newLine();
        }
        bw.close();
    }
}

class Person implements Comparable<Person> {
    private int join;
    private int age;
    private String name;

    public Person(int join, int age, String name) {
        this.join = join;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return age + " " + name;
    }

    @Override
    public int compareTo(Person o) {
        if(this.age == o.age) {
            return this.join - o.join;
        }

        return this.age - o.age;
    }
}