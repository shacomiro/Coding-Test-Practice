import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    
    public int solution(String numbers) {
        int answer = 0;
        
        String[] splitNum = numbers.split("");
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        
        for(int length = 1; length <= splitNum.length; length++) {
            dfs(0, length, new int[splitNum.length], splitNum, new String[getFactorial(splitNum.length)], set);
        }
        
        primeCheck(set, list);
        
        return list.size();
    }
    
    public void dfs(int length, int size, int[] check, String[] baseArr, String[] selects, Set<Integer> set) {
        if(length == size) {
            String num = "";
            for(int i = 0; i < size; i++) {
                num += selects[i];
            }
            set.add(Integer.parseInt(num));
        } else {
            for(int i = 0; i < baseArr.length; i++) {
                if(check[i] == 0) {
                    check[i] = 1;
                    selects[length] = baseArr[i];
                    dfs(length + 1, size, check, baseArr, selects, set);
                    check[i] = 0;
                }
            }
        }
    }
    
    public int getFactorial(int size) {
        return size == 1 ? 1 : size * getFactorial(size - 1);
    }
    
    public void primeCheck(Set<Integer> set, List<Integer> list) {
        for(int num : set) {
            boolean isPrime = true;
            
            if(num == 0 || num == 1) {
                isPrime = false;
            } else {
               for(int divisor = 2; divisor <= (int) Math.sqrt(num); divisor++) {
                    if(num % divisor == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            
            if(isPrime) list.add(num);
        }
    }
}
//+3