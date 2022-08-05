package Car;

public class Car implements ICar {
	// 초기상태
	// 기어변속 상태: P, 속도: 0km, 타이어종류: 한국타이어, 모든 창문: closed, 와이퍼: Off, 깜박이: Off
	private Gear gear = new Gear();
	private Windows[] windows = new Windows[4];
	private Tire tire = new Tire();
	private Blinker blinker = new Blinker();
	private Wifer wifer = new Wifer();
	private int type = 0;
	private boolean isOn = false;
	private boolean isPass = false;
	private String option = null;
	
	public Car() {
		isOn = true;
		for(int i = 0; i < windows.length; i++) {
			windows[i] = new Windows();
		}
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
			while(!isPass) {
				System.out.println("기어변속 (1: 1단 | 2: 2단 | 3: 3단 | 4: 4단 | 5: 5단 | 6: 6단 | R: 후진)");
				System.out.print("동작을 선택하세요> ");
				try {
					gear.inputCommand();
					isPass = true;
				} catch (InputException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}	
			}
			isPass = false;
			break;
			
		case "2":
			printCarSpeed();
			break;
			
		case "3":
			while(!isPass) {
				System.out.println("타이어교체 (1: 미쉐린 | 2: 금호 | 3: 한국타이어 | 4: 컨티넨탈)");
				System.out.print("동작을 선택하세요> ");
				try {
					tire.inputCommand();
					isPass = true;
				} catch (InputException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}	
			}
			isPass = false;
			break;
			
		case "4":
			while(!isPass) {
				System.out.println("창문선택 (1: 운전석 | 2: 조수석 | 3: 뒷창문 오른쪽 | 4: 뒷창문 왼쪽)");
				System.out.print("동작을 선택하세요> ");
				Selector selector = new Selector() {
					
					String option;
					@Override
					public void inputCommand() throws InputException {
						// TODO Auto-generated method stub
						option = sc.nextLine();
						if(checkInputException(option)) {
							run();
						} else {
							throw new InputException("잘못된 입력입니다. 다시 선택하세요.");
						}
					}

					@Override
					public void run() {
						// TODO Auto-generated method stub
						type = Integer.parseInt(option);
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
				};
				try {
					selector.inputCommand();
					isPass = true;
				} catch (InputException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}
			isPass = false;
			
			System.out.println("1: 열기 | 2: 닫기");
			System.out.print("동작을 선택하세요> ");
			try {
				windows[type-1].inputCommand();
			} catch (InputException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			break;
			
		case "5":
			while(!isPass) {
				System.out.println("와이퍼선택 (1: 와이퍼 On | 2: 와이퍼 Off)");
				System.out.print("동작을 선택하세요> ");
				try {
					wifer.inputCommand();
					isPass = true;
				} catch (InputException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}
			isPass = false;
			break;
			
		case "6":
			while(!isPass) {
				System.out.println("깜빡이선택 (1: 좌측깜빡이 On | 2: 우측깜빡이 On | 3: 비상깜빡이 On | 4: 끄기)");
				System.out.print("동작을 선택하세요> ");
				try {
					blinker.inputCommand();
					isPass = true;
				} catch (InputException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}
			isPass = false;
			break;
			
		case "7":
			printCarInfo();
			break;
		case "8":
			gear.init();
			break;
		case "9":
			this.isOn = false;
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
		case "7":
		case "8":
		case "9":
			return true;
		}
		return false;
	}

	@Override
	public void printCarInfo() {
		// TODO Auto-generated method stub
		printCarSpeed();
		System.out.println("타이어종류: " + tire.getCompany());
		for(int i = 0; i < windows.length; i++) {
			switch(i+1) {
			case 1:
				System.out.println("운전석 창문: " + windows[i].getState());
				break;
			case 2:
				System.out.println("보조석 창문: " + windows[i].getState());
				break;
			case 3:
				System.out.println("뒷창문 오른쪽: " + windows[i].getState());
				break;
			case 4:
				System.out.println("뒷창문 왼쪽: " + windows[i].getState());
				break;
			}
		}
		System.out.println("와이퍼상태: " + wifer.getState());
		System.out.println("기어변속상태: " + gear.getType());
		System.out.println("깜빡이상태: " + blinker.getType());
	}

	@Override
	public void printCarSpeed() {
		// TODO Auto-generated method stub
		if(gear.getType().equals("후진")) {
			System.out.println("현재속도: R");
		} else {
			System.out.println("현재속도: " + gear.getSpeed() + "km");
		}
	}
	
	public boolean isOn() {
		return isOn;
	}
}
