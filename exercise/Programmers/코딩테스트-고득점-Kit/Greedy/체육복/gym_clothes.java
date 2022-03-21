package greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class gym_clothes {

	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2, 4};
		int[] reserve = {3, 1};
		
		System.out.println(solution(n, lost, reserve));
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		List<Integer> remainLost = new ArrayList<>();
		List<Integer> remainReserve = new ArrayList<>();
		
		for (int element : lost) {
			remainLost.add(element);
		}
		for (int element : reserve) {
			remainReserve.add(element);
		}
		
		remainReserve.sort(Comparator.naturalOrder());
		remainLost.sort(Comparator.naturalOrder());
		
		int notBorrow = 0;
		boolean replaceFlag, leftCheck, rightCheck;
		
		
		for(int i = 0; i < remainLost.size(); i++) {
			int idx = remainReserve.indexOf(remainLost.get(i));
			
			if(remainReserve.contains(remainLost.get(i))) {
				remainLost.remove(i--);
				remainReserve.remove(idx);
			}
		}
		
		for(int element : remainLost) {
			System.out.print(element + " ");
		}
		System.out.println();
		for(int element : remainReserve) {
			System.out.print(element + " ");
		}
		
		System.out.println();
		
		
		System.out.println("통과?");
				
		while(remainLost.size() > 0 && remainReserve.size() > 0) { 
			replaceFlag = false;
			leftCheck = remainReserve.contains(remainLost.get(0) - 1);
			rightCheck = remainReserve.contains(remainLost.get(0) + 1);
			
			System.out.print("[" + remainLost.get(0) + "]" + leftCheck + "<좌 우>" + rightCheck + "==>");
			
			
			if(leftCheck || rightCheck) {
				if(leftCheck && !replaceFlag) {
					remainReserve.remove(remainReserve.indexOf(remainLost.get(0) - 1));
					replaceFlag = true;
					
					System.out.println("앞번호에게 빌림");
				}
				
				if(rightCheck && !replaceFlag) {
					remainReserve.remove(remainReserve.indexOf(remainLost.get(0) + 1));
					replaceFlag = true;
					
					System.out.println("뒷번호에게 빌림");
				}
			} else {
				notBorrow++;
				System.out.println("빌리지 못함.");
			}
			
			remainLost.remove(0);
		}
		
		int answer = n - (notBorrow + remainLost.size());
		return answer;
	}
}
