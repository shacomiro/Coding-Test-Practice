import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(long n) {
        String[] nString = String.valueOf(n).split("");
        List<Integer> nList = Arrays.stream(nString).mapToInt(x -> Integer.parseInt(x)).boxed().collect(Collectors.toList());
        Collections.reverse(nList);
        
        return nList.stream().mapToInt(x -> Integer.valueOf(x)).toArray();
    }
}

//너무 복잡함. 보완 필요.
//Stringbuffer나 StringBuilder, 또는 자릿수를 10씩 나누어 없애는 방식을 사용해서 다시 풀어볼 것.