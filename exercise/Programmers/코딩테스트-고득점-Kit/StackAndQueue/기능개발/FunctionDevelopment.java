package stacknqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FunctionDevelopment {

	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		
		for(int element : solution(progresses, speeds)) {
			System.out.println(element);
		}
	}
	
	//기능개발
	public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		Queue<Integer> progressStatus = new LinkedList<>();
		Queue<Integer> speedsInfo = new LinkedList<>();
		List<Integer> distribution = new ArrayList<>();
		
		for(int i = 0; i < progresses.length; i++) {
			progressStatus.offer(progresses[i]);
			speedsInfo.offer(speeds[i]);
		}
		
		while(!progressStatus.isEmpty()) {
			int completeWorks = 0;
						
			while(progressStatus.peek() >= 100) {
				completeWorks++;
				progressStatus.poll();
				speedsInfo.poll();
				
				if(progressStatus.isEmpty()) break;
			}
			
			if(completeWorks != 0) distribution.add(completeWorks);
			
			for(int i = 0; i < progressStatus.size(); i++) {
				int currentProgress = progressStatus.poll();
				int currentSpeed = speedsInfo.poll();
								
				progressStatus.offer((currentProgress >= 100) ? currentProgress : (currentProgress + currentSpeed));
				speedsInfo.offer(currentSpeed);
			}
		}
		
		answer = new int[distribution.size()];
		for(int i = 0; i < distribution.size(); i++) {
			answer[i] = distribution.get(i);	
		}
		
		return answer;
	}
}
