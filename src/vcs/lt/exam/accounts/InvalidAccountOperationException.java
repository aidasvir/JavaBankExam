package vcs.lt.exam.accounts;

public class InvalidAccountOperationException extends Exception {
	private String message;

	public InvalidAccountOperationException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
	
}
