class Solution {
    public boolean solution(int x) {
		String[] splitX = Integer.toString(x).split("");
		int sum = 0;
		
		for(String num : splitX) {
			sum += Integer.parseInt(num);
		}
		
		return x % sum == 0 ? true : false;
    }
}