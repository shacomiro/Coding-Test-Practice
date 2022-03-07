package devMatching2021WebBackendDeveloper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HighestAndLowestRankOfLottery {

	public static void main(String[] args) {
		int[] lottos = {45, 4, 35, 20, 3, 9};
		int[] win_nums = {20, 9, 3, 45, 4, 35};
		
		for(int i : solution(lottos, win_nums)) System.out.print(i + " ");
	}

	//로또의 최고 순위와 최저 순위
	public static int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];
		List<Integer> lottosList = new ArrayList<Integer>(Arrays.stream(lottos).boxed().collect(Collectors.toList()));
		List<Integer> winNumsList = new ArrayList<Integer>(Arrays.stream(win_nums).boxed().collect(Collectors.toList()));
		int point = 0;
		int unkownPoint = 0;
		
		for(int number : lottosList) {
			if(winNumsList.contains(number)) {
				point++;
			} else if(number == 0) {
				unkownPoint++;
			}
		}
		
		answer[0] = Math.min(6 - (point + unkownPoint) + 1, 6);
		answer[1] = Math.min(6 - (point) + 1, 6);
		
		return answer;
	}
}
