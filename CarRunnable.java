package Car;

public class CarRunnable {
	public static void main(String[] args) {
		long startTime;
		long endTime;
		int operationTime;
		Car myCar = new Car();
		
		startTime = System.currentTimeMillis();
		while(myCar.isOn()) {
			System.out.println("1: 기어변속 | 2: 현재속도 | 3: 타이어교체 | 4: 창문 | 5: 와이퍼 | 6: 깜빡이 | 7: 현재상태 | 8: 브레이크 | 9. 종료");
			System.out.print("메뉴를 선택하세요> ");
			try {
				myCar.inputCommand();
			} catch (InputException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		endTime = System.currentTimeMillis();
		operationTime = (int) ((endTime - startTime) / 1000);
		System.out.println("운행시간: " + operationTime + "초");
		System.out.println("안녕히계세요.");
	}
}