package Car;

public class Windows implements Selector{
	
	private String option;
	private String state;
	
	public Windows() {
		this.option = null;
		this.state = "closed";
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
			this.state = "opened";
			break;
		case "2":
			this.state = "closed";
			break;
		}
	}

	@Override
	public boolean checkInputException(String option) {
		// TODO Auto-generated method stub
		switch(option) {
		case "1":
		case "2":
			return true;
		}
		return false;
	}
	
	public String getState() {
		return state;
	}
}
