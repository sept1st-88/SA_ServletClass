
public class TestForEx1 {
	public static void main(String[] args) {

		String[] strArr = new String[10];

		for (int i = 0; i < strArr.length; i++) {
			strArr[i] = "사람이름" + i;
		}
		
		System.out.println("원래 for문");
		for (int i = 0; i < strArr.length; i++) {
			System.out.print(strArr[i] + " ");
		}
		
		System.out.println();
		
		System.out.println("확장된 for문");
		for (String test : strArr) { // 그룹화타입(배열/리스트)만 됨
			System.out.print(test + " ");
		}

	}
}
