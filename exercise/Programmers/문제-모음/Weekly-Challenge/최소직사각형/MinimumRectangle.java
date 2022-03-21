package weekly_challenge;

public class MinimumRectangle {

	public static void main(String[] args) {
		int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		
		System.out.println(solution(sizes));
	}
	
	//최소직사각형
	public static int solution(int[][] sizes) {
		int result;
		int minWidth = 0;
		int minHeight = 0;
		
		for(int[] card : sizes) {
			int originGap = Math.abs((minWidth - card[0])) + Math.abs((minHeight - card[1]));
			int turnedGap = Math.abs((minWidth - card[1])) + Math.abs((minHeight - card[0]));
			
			if(originGap > turnedGap) {
				if(card[1] > minWidth) minWidth = card[1];
				if(card[0] > minHeight) minHeight = card[0];
			} else {
				if(card[0] > minWidth) minWidth = card[0];
				if(card[1] > minHeight) minHeight = card[1];
			}
		}
		
		result = minWidth * minHeight;
		
		return result;
	}
}
