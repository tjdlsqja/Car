package Car;

public class Gear implements Selector{

	private String option;
	private String type;
	private int speed;
	
	
	public Gear() {
		speed = 0;
		type = "P";
		option = null;
	}
	
	@Override
	public void inputCommand() throws InputException {
		// TODO Auto-generated method stub
		String option = sc.nextLine();
		if(checkInputException(option)) {
			this.option = option;
			run();
		} else {
			throw new InputException("잘못된 입력입니다. 다시 선택하세요.");
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		switch(option) {
		case "1":
			this.type = "1단";
			this.speed = (int)(Math.random() * 10) + 10;
			break;
		case "2":
			this.type = "2단";
			this.speed = (int)(Math.random() * 10) + 20;
			break;
		case "3":
			this.type = "3단";
			this.speed = (int)(Math.random() * 10) + 30;
			break;
		case "4":
			this.type = "4단";
			this.speed = (int)(Math.random() * 10) + 40;
			break;
		case "5":
			this.type = "5단";
			this.speed = (int)(Math.random() * 10) + 50;
			break;
		case "6":
			this.type = "6단";
			this.speed = (int)(Math.random() * 10) + 100;
			break;
		case "R":
			this.type = "후진";
			break;
		}
	}

	@Override
	public boolean checkInputException(String option) {
		// TODO Auto-generated method stub
		switch(option) {
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "R":
			return true;
		}
		return false;
	}
	
	// 기어변속 타입, 속도 초기화
	public void init() {
		setSpeed(0);
		setType("P");
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public int getSpeed() {
		return speed;
	}

}
