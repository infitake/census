package census.exceptions;

public class WrongInfoException extends Exception{

	public WrongInfoException() {
		// TODO Auto-generated constructor stub
	}

	public WrongInfoException(String message) {
		super(message);
		System.out.print("name is wrong");
		// TODO Auto-generated constructor stub
	}

}