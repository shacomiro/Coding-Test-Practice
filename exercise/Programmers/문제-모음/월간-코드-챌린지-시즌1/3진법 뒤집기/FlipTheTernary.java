class Solution {
    public int solution(int n) {
        int answer = 0;
		String ternaryCode = "";
		
		while(n != 0) {
			ternaryCode = ternaryCode.concat(Integer.toString(n % 3));
			n /= 3;
		};
        
        String[] ternaryArr = ternaryCode.split("");
        int digit = ternaryArr.length - 1;
        
		for(String num : ternaryArr) {
			answer += Integer.parseInt(num) * Math.pow(3, digit--);
		}
        
		return answer;
    }
}