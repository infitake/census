package census.exceptions;

public class MemberNotFoundException extends Exception {

	public MemberNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public MemberNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MemberNotFoundException(Integer id) {
		System.out.println("id not found"+id);
		// TODO Auto-generated constructor stub
	}

	public MemberNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
