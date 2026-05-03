package vinix.services.exceptions;

public class StringException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public StringException(String msg) {
		super(msg + " -> Não foi encontrado");
	}

}
