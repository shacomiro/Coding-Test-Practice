package weekly_challenge;

public class CalculateTheInsufficientAmount {

	public static void main(String[] args) {
		System.out.println(solution(3, 20, 4));
	}
	
	//부족한 금액 계산하기
	public static long solution(int price, int money, int count) {
		long requiredMoney = 0;
		int times = 0;
		
		while(count-- != 0) {
			times++;
			requiredMoney += price * times;
		}
		
		long answer = money - requiredMoney < 0 ? Math.abs(money - requiredMoney) : 0;
		
		return answer;
	}
}