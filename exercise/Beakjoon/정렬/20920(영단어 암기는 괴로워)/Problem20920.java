import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Solution20920 {
    Map<String, Integer> vocabularyList;

    public Solution20920(List<String> words, int lengthLimit) {
        this.vocabularyList = new HashMap<>();

        for(String word : words) {
            if(word.length() >= lengthLimit) {
                vocabularyList.put(word, vocabularyList.getOrDefault(word, 0) + 1);
            }
        }
    }

    public String solve() {
        List<String> vocas = new ArrayList<>(vocabularyList.keySet());
        Collections.sort(vocas, new Comparator<String>() {
            @Override
            public int compare(String k1, String k2) {
                int countGap = vocabularyList.get(k2) - vocabularyList.get(k1);
                if(countGap != 0) {
                    return countGap;
                }

                int lengthGap = k2.length() - k1.length();
                if(lengthGap != 0) {
                    return lengthGap;
                }

                return k1.compareTo(k2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String voca : vocas) {
            sb.append(voca).append("\n");
        }

        return sb.toString();
    }
}

public class Problem20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<String> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        bw.write(new Solution20920(list, m).solve());
        bw.flush();
        bw.close();
    }
}
