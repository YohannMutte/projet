package projetBank;


public class BanqueException extends java.lang.Exception{
	
	
	public BanqueException(){
		super();
	}
	
	public BanqueException(String message) {
		super(message);
	}

	public BanqueException(Throwable cause) {
		super(cause);
	}

	public BanqueException(String message, Throwable cause) {
		super(message, cause);
	}
}
