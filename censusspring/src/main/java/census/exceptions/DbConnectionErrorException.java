package census.exceptions;

public class DbConnectionErrorException extends Exception {

	public DbConnectionErrorException() {
		super();
	}

	public DbConnectionErrorException(String message) {
		super(message);
		System.out.println("This is the mssg"+message);
	}


}
