import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution25206 {
    private List<Subject> majorSubjects;
    
    public Solution25206(List<Subject> majorSubjects) {
        this.majorSubjects = majorSubjects;
    }
    
    public String solve() {
        return String.format("%.6f", getMajorGPA());
    }
    
    private double getMajorGPA() {
        double gradePointSum = 0;
        double creditSum = 0;
        
        for(Subject subject : majorSubjects) {
            if(subject.getGrade().equals("P")) {
                continue;
            }
            
            gradePointSum += subject.getGradePoint();
            creditSum += subject.getCredit();
        }
        
        return gradePointSum / creditSum;
    }
    
    static class Subject {
        String name;
        double credit;
        String grade;
        
        public Subject(String name, double credit, String grade) {
            this.name = name;
            this.credit = credit;
            this.grade = grade;
        }
        
        public double getCredit() {
            return credit;
        }
        
        public String getGrade() {
            return grade;
        }
        
        public double getGradePoint() {
            double gradePoint = 0.0;
            
            switch(grade) {
                case "A+":
                    gradePoint = 4.5;
                    break;
                case "A0":
                    gradePoint = 4.0;
                    break;
                case "B+":
                    gradePoint = 3.5;
                    break;
                case "B0":
                    gradePoint = 3.0;
                    break;
                case "C+":
                    gradePoint = 2.5;
                    break;
                case "C0":
                    gradePoint = 2.0;
                    break;
                case "D+":
                    gradePoint = 1.5;
                    break;
                case "D0":
                    gradePoint = 1.0;
                    break;
            }
            
            return gradePoint * credit;
        } 
    }
}

public class Problem25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        List<Solution25206.Subject> list = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Solution25206.Subject(st.nextToken(), Double.parseDouble(st.nextToken()), st.nextToken()));
        }
        
        bw.write(new Solution25206(list).solve());
        bw.flush();
        bw.close();
    }
}
