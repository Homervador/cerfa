package exception.model;

public class ModelException extends Exception{
	
	public ModelException(String message, Throwable cause){
		super(message, cause);
	}
	
	public ModelException(String message){
		super(message);
	}
	
}
