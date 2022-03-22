class Solution {
    public int solution(int n) {
		int num1 = 0;
		int num2 = 1;
		int NumOfN = num1 + num2;
		int cnt = 2;
		
		while(cnt < n) {
			num1 = num2 % 1234567;
			num2 = NumOfN % 1234567;
			NumOfN = (num1 + num2) % 1234567;
			
			cnt++;
		}
		
		return (int) NumOfN;
    }
}
//+9