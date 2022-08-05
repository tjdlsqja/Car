package Car;

public class Blinker implements Selector{

	private String option;
	private String type;
	
	public Blinker() {
		this.option = null;
		this.type = "깜빡이 Off";
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
			this.type = "좌측깜빡이 On";
			break;
		case "2":
			this.type = "우측깜빡이 On";
			break;
		case "3":
			this.type = "비상깜빡이 On";
			break;
		case "4":
			this.type = "깜빡이 Off";
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
			return true;
		}
		return false;
	}
	
	public String getType() {
		return type;
	}
}
