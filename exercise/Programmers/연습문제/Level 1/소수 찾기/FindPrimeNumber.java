import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int n) {
        int answer = 0;
        List<Integer> primeList = new ArrayList<Integer>();
        
        for(int i = 2; i <= n; i++) {
            int targetNum = i;
            boolean isPrime = true;

            if(primeList.size() != 0) {
                for(int prime : primeList) {
                    if(prime > (int) Math.sqrt(targetNum)) break;
                    if(targetNum % prime == 0) {
                        isPrime = false;
                        break;
                    }
                }
            } else {
                if(targetNum % 2 == 1) {
                    isPrime = false;
                }
            }

            if(isPrime) primeList.add(targetNum);
        }
        
        return primeList.size();
    }
}