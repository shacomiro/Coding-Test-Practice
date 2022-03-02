package weekly_challenge;

public class CalculateTheInsufficientAmount {

	public static void main(String[] args) {
		System.out.println(solution(3, 20, 4));
	}
	
	//부족한 금액 계산하기
	public static long solution(long price, long money, long count) {
		return Math.max((count * (2 * price + (count - 1) * price)) / 2 - money, 0);
	}
}