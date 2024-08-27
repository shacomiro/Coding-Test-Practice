import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Solution1946 {
    private List<Applicant> applicants;

    public Solution1946(List<Applicant> applicants) {
        this.applicants = applicants;
    }

    public String solve() {
        Collections.sort(applicants);
        int interviewLimit = applicants.get(0).getInterviewRank();

        int count = 0;
        for(Applicant applicant : applicants) {
            if(applicant.getInterviewRank() <= interviewLimit) {
                count++;
                interviewLimit = applicant.getInterviewRank();
            }
            
        }

        return String.valueOf(count);
    }

    static class Applicant implements Comparable<Applicant> {
        private int resumeRank;
        private int interviewRank;

        public Applicant(int resumeRank, int interviewRank) {
            this.resumeRank = resumeRank;
            this.interviewRank = interviewRank;
        }

        public int getResumeRank() {
            return resumeRank;
        }

        public int getInterviewRank() {
            return interviewRank;
        }

        @Override
        public int compareTo(Solution1946.Applicant o) {
            return this.resumeRank - o.resumeRank;
        }
    }
}

public class Problem1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            List<Solution1946.Applicant> list = new ArrayList<>(n);
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                list.add(new Solution1946.Applicant(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            bw.write(new Solution1946(list).solve());
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}