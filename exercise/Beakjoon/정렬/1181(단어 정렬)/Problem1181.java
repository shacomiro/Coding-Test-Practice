import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Problem1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        SortedSet<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                if(str1.length() == str2.length()) {
                    return str1.compareTo(str2);
                }
                return str1.length() - str2.length();
            }
        });
        
        for(int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        for(String s : set) {
            bw.write(s);
            bw.newLine();
        }
        bw.close();
    }
}
