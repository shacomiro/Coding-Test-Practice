import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m, n;
    static int[][] plate;
    static int day = 0;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public void bfs(ArrayList<int[]> ripen) {
        Queue<int[]> queue = new LinkedList<>();
        for(int[] coor : ripen) queue.offer(coor);
        boolean flag;

        while(!queue.isEmpty()) {
            int len = queue.size();
            flag = true;

            for(int i = 0; i < len; i++) {
                int[] tmp = queue.poll();

                for(int j = 0; j < 4; j++) {
                    int nx = tmp[0] + dx[j];
                    int ny = tmp[1] + dy[j];

                    if(0 <= nx && nx < n && 0 <= ny && ny < m && plate[nx][ny] == 0) {
                        plate[nx][ny] = 1;
                        queue.offer(new int[] {nx, ny});
                        ripen.add(new int[] {nx, ny});
                        flag = false;
                    }
                }
            }

            if(flag) break;
            day++;
        }
    }

    class Point{
        public int x, y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    static int[][] board, dis;
    static Queue<Point> Q=new LinkedList<>();

    public void BFS(){
        while(!Q.isEmpty()){
            Point tmp=Q.poll();
            for(int i=0; i<4; i++){
                int nx=tmp.x+dx[i];
                int ny=tmp.y+dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny]==0){
                    board[nx][ny]=1;
                    Q.offer(new Point(nx, ny));
                    dis[nx][ny]=dis[tmp.x][tmp.y]+1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st1.nextToken());
        n = Integer.parseInt(st1.nextToken());
        plate = new int[n][m];

        board=new int[n][m];
        dis=new int[n][m];

        for(int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int tomato = Integer.parseInt(st2.nextToken());
                plate[i][j] = tomato;

                board[i][j] = tomato;
                if(board[i][j]==1) Q.offer(new Point(i, j));
            }
        }

//        ArrayList<int[]> ripen = new ArrayList<>();
//        int cnt = 0;
//
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < m; j++) {
//                if(plate[i][j] != -1) {
//                    if(plate[i][j] == 1) ripen.add(new int[] {i, j});
//                    cnt++;
//                }
//            }
//        }
//
//        if(ripen.size() == cnt) System.out.println(0);
//        else {
//            T.bfs(ripen);
//            if(ripen.size() == cnt) System.out.println(day);
//            else System.out.println(-1);
//        }

        T.BFS();
        boolean flag=true;
        int answer=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]==0) flag=false;
            }
        }
        if(flag){
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    answer=Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        }
        else System.out.println(-1);
    }
}
