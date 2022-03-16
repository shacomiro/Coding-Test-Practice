import java.time.LocalDate;

class Solution {
    public String solution(int a, int b) {
        String[] dayOfWeekStr = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        LocalDate date = LocalDate.of(2016, a, b);
        int dayOfWeekNum = date.getDayOfWeek().getValue();
        
        return dayOfWeekStr[dayOfWeekNum - 1];
    }
}