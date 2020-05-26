import java.util.ArrayList;

public class TestForTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		1 월
//		2 화
//		3 수
//		4 목
//		5 금
//		6 토
//		7 일
		
		ArrayList<String> weekdayList = new ArrayList<String>();
		
		weekdayList.add("월");
		weekdayList.add("화");
		weekdayList.add("수");
		weekdayList.add("목");
		weekdayList.add("금");
		weekdayList.add("토");
		weekdayList.add("일");
		
		System.out.println("기존 for문");
		for (int i = 0; i < weekdayList.size(); i++) {
			System.out.println((i+1) + " " + weekdayList.get(i));
		}
		
		System.out.println();
		
		int count = 1;
		
		System.out.println("확장된 for문");
		for (String weekdaylist : weekdayList) {
			System.out.println(count + " " + weekdaylist);
//			System.out.println((weekdayList.indexOf(weekdaylist)+1) + " " + weekdaylist);
			count++;
		}
		
	}

}
