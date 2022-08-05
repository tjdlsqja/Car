package Car;

public class Tire implements Selector{

	private String option;
	private String company;
	
	public Tire() {
		this.option = null;
		this.company  = "한국타이어";
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
			this.company = "미쉐린";
			break;
		case "2":
			this.company = "금호";
			break;
		case "3":
			this.company = "한국타이어";
		case "4":
			this.company = "컨티넨탈";
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
	
	public String getCompany() {
		return company;
	}
}
