import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class test {
	public static ArrayList<ArrayList<String>> maze = new ArrayList<ArrayList<String>>(); // 미로 ArrayList 생성
	public static HashMap<Integer, ArrayList<ArrayList<String>>> mazeSolution = new HashMap<Integer, ArrayList<ArrayList<String>>>();
	public static HashMap<Integer, Path> pathMap = new HashMap<Integer, Path>();
	public static int sw = 0;
	public static int count = 0;
	
	public static void main(String[] args) {
		ArrayList<ArrayList<String>> maze = readMaze();
		
		int x = 0, y = 0;
		
		// 풀이 전 미로 파일 출력
		for(int i=0; i<maze.size(); i++) {
			for(int j=0; j<maze.get(i).size(); j++) {
				System.out.print(maze.get(i).get(j));
				if(maze.get(i).get(j).equals("S")) {
					x = i;
					y = j;
				}
			}
		}
			
		System.out.println();
		System.out.println();
		
		Path path = new Path();
		path.setPathMap(new HashMap<Integer, int[]>());
		
		dfs(maze, x, y, path);
		
		System.out.println();
		
		
		int min = pathMap.get(0).getSize();
		int best = 0;
		
		for(int i=0; i<pathMap.size(); i++) {
			if(min > pathMap.get(i).getSize()) {
				min = pathMap.get(i).getSize();
				best = i;
			}
			System.out.println("Goal (" + pathMap.get(i).getSize() + ")");
		}
		
		ArrayList<ArrayList<String>> bestMaze = mazeSolution.get(best);
		System.out.println("탈출 가능한 경로 : " + count + "개");
		System.out.println("최단 경로 : Route" + best + ", 경로 길이 : " + pathMap.get(best).getSize());
		
		for(int i=0; i<bestMaze.size(); i++) {
			for(int j=0; j<bestMaze.get(i).size(); j++) {
				System.out.print(bestMaze.get(i).get(j));
			}
		}
	}

	public static void dfs(ArrayList<ArrayList<String>> maze, int i, int j, Path path) {
		// 미로 풀이
		int[] code = {i, j};
		
		if(maze.get(i).get(j).equals(" ") || maze.get(i).get(j).equals("S")) {
			if(maze.get(i).get(j).equals(" ") || maze.get(i).get(j).equals("S")) {
				if(!maze.get(i).get(j).equals("S")) {
					maze.get(i).set(j, "*");
					path.putPathMap(path.size++, code);
				}
				
				if(i+1 < maze.size()) dfs(maze, i+1, j, path); //하
				if(j+1 < maze.get(i).size()) dfs(maze, i, j+1, path); //우
				if(j-1 >= 0) dfs(maze, i, j-1, path); //좌
				if(i-1 >= 0) dfs(maze, i-1, j, path); //상
				
				if(!maze.get(i).get(j).equals("S")) {
					maze.get(i).set(j, " ");
					path.getPathMap().remove(path.size--);
				}
			}
		} else if(maze.get(i).get(j).equals("G")) {
			Path resultPath = null;
			ArrayList<ArrayList<String>> mazeSol = new ArrayList<ArrayList<String>>();
			try {
				resultPath = (Path)path.clone();
				mazeSol = SubjectList_Copy(maze);
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			pathMap.put(count, resultPath);
			mazeSolution.put(count, mazeSol);
			
			count++;
		}
	}
	
	public static ArrayList<ArrayList<String>> readMaze() {
		// 미로 파일 읽기
		try{
	        //파일 객체 생성
	        File file = new File("D:/Development/work/maze/src/maze/maze.txt"); // 미로 파일 경로
	         //입력 스트림 생성
	         FileReader file_reader = new FileReader(file);
	         int cur = 0;
	         ArrayList<String> line = new ArrayList<String>();
	         while(true){
	        	cur = file_reader.read();
	            line.add(Character.toString((char)cur));
	            if((char)cur == '\n') {
	            	maze.add(line);
	            	line = new ArrayList<String>();
	            } else if(cur == -1) {
	            	maze.add(line);
	            	break;
	            }
	         }
	         file_reader.close();
        }catch (FileNotFoundException e) {
            e.getStackTrace();
        }catch(IOException e){
            e.getStackTrace();
        }
		
		return maze;
	}
	
	public static ArrayList<ArrayList<String>> SubjectList_Copy(ArrayList<ArrayList<String>> list){
	    ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();
	    for(ArrayList<String> list_item: list){
	        temp.add((ArrayList<String>) list_item.clone());
	    }
	    return temp;
	}
}

class Path implements Cloneable {
	public int size;
	public HashMap<Integer, int[]> pathMap;
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public HashMap<Integer, int[]> getPathMap() {
		return pathMap;
	}
	public void setPathMap(HashMap<Integer, int[]> pathMap) {
		this.pathMap = pathMap;
	}
	public void putPathMap(Integer key, int[] value) {
		pathMap.put(key, value);
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
