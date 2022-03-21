package sort;

import java.util.Arrays;

public class KthNumber {

	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		for(int element : solution(array, commands)) {
			System.out.println(element);
		}
		
	}

	//K번째수
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		for(int i = 0; i < commands.length; i++) {
			int[] tempArray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
			Arrays.sort(tempArray);
			answer[i] = tempArray[commands[i][2] - 1];
		}		
		
		return answer;
	}
}
