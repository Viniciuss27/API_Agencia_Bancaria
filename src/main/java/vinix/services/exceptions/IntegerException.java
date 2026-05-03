package vinix.services.exceptions;

public class IntegerException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public IntegerException(Object id) {
		super(id +" -> Não foi encontrado");
	}

	
}
