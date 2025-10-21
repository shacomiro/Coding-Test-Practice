import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem5554 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());

        bw.write(new Solver(a, b, c, d).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int fromHomeToSchool;
        private int fromSchoolToPCBang;
        private int fromPCBangToAcademy;
        private int fromAcademyToHome;

        public Solver(int fromHomeToSchool, int fromSchoolToPCBang, int fromPCBangToAcademy, int fromAcademyToHome) {
            this.fromHomeToSchool = fromHomeToSchool;
            this.fromSchoolToPCBang = fromSchoolToPCBang;
            this.fromPCBangToAcademy = fromPCBangToAcademy;
            this.fromAcademyToHome = fromAcademyToHome;
        }

        public String solve() {
            int time = fromHomeToSchool + fromSchoolToPCBang + fromPCBangToAcademy + fromAcademyToHome;

            return time / 60 + "\n" + time % 60;
        }
    }
}
