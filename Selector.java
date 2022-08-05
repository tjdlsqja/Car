package Car;

import java.util.Scanner;

public interface Selector {
	Scanner sc = new Scanner(System.in);
	
	void inputCommand() throws InputException;
	void run();
	boolean checkInputException(String option);
}
