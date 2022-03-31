class Solution {
    public int solution(String name) {
        int move = 0;
        char[] names = name.toCharArray();
        char[] output = new char[name.length()];
        for(int i = 0; i < output.length; i++) {
            output[i] = 'A';
        }
        
        int cursor = 0;
        int vector = 1;
        int[] weight = new int[name.length()];
        int cnt = 0;
        StringBuilder sb = new StringBuilder(name);
        
        int startA = -1;
        int endA = -1;
        int gapA = 0;
        int[] longestA = {-1, -1};
        boolean flag = true;
        
        for(int i = 0; i < weight.length; i++) {
            int target = (int) sb.charAt(i);

            if(target != 65)
                cnt++;
            
            if(target - 65 <= 13)
                weight[i] = target - 65;
            else
                weight[i] = 91 - target;
            
            //A를 처음 만나면
            if(startA == -1 && weight[i] == 0) {
                startA = i;
            }
            
            //A가 아닌 것을 만나면
            if(startA != -1 && weight[i] != 0 && i > startA) {
                endA = i - 1;
                
                if(gapA <= Math.abs(startA - endA) + 1) {
                    gapA = Math.abs(startA - endA) + 1;
                    longestA[0] = startA;
                    longestA[1] = endA;
                }
                
                startA = -1;
            }
        }
        
        //System.out.println("가장 긴 A들의 첫 A 인덱스 : " + longestA[0]);
        //System.out.println("가장 긴 A들의 끝 A 인덱스 : " + longestA[1]);
            //A(0)를 만나고 A(0)가 몇번 연속되는가를 점검
            //가장 긴 범위를 가지는 A(0)의 시작 및 종료 인덱스(커서)를 기억하고 이를 통해 판별하기
            //이후
        //기본 커서 위치(0)에서 startA가 가까운지 endA가 가까운지 체크
        //기본위치~startA가 나오기 직전 문자 -> startA(4) - 1 = 3이동
        //기본위치~endA가 나오기 직전 문자   -> weight.length(13) - endA(10) - 1 = 2이동
        //startA보다 endA쪽이 가깝다면, weight[endA+1]를 먼저 처리하기 전까지는 vector=-1로 지정해야 함.
        
        while(true) {
            int left, right;
            // 2 - 1 > 5 - 3 - 1 => 1 > 1
            if(longestA[0] - 1 > weight.length - longestA[1] - 1 && flag) {
                cursor = longestA[1] + 1;
                move += weight.length - longestA[1] - 1;
                //System.out.println("이동 : " + (weight.length - longestA[1] - 1)+",이동한 커서 : " + cursor);
                move += weight[cursor];
                weight[cursor] = 0;
                cnt--;
            }
            flag = false;
            
            if(weight[cursor] != 0) {
                move += weight[cursor];
                //System.out.println("가중치 "+weight[cursor]+" 처리 || 누적 이동 : "+move);
                weight[cursor] = 0;
                cnt--;
            }
            
            if(cnt == 0) break;
            
            if(cursor + 1 == weight.length) right = 0;
            else right = cursor + 1;
            if(cursor - 1 == -1) left = weight.length - 1;
            else left = cursor - 1;
            move++;
            //System.out.println("이동 1회 | 누적 : "+move);
            //ABABAAAAAAABA
            //
            //1+1+2+1+5+1=11
            
            while(true) {
                if(weight[left] != 0 && weight[right] != 0) {
                    if(vector == 1) {
                        cursor = right;
                    } else {
                        cursor = left;
                    }
                    break;
                } else if(weight[left] == 0 && weight[right] != 0) {
                    vector = 1;
                    cursor = right;
                    break;
                } else if(weight[left] != 0 && weight[right] == 0) {
                    vector = -1;
                    cursor = left;
                    break;
                }
                
                if(right + 1 == weight.length) right = 0;
                else right += 1;
                if(left - 1 == -1) left = weight.length - 1;
                else left -= 1;
                move++;
                //System.out.println("이동 1회 | 누적 : "+move);
            }
        }
        
        return move;
    }
}