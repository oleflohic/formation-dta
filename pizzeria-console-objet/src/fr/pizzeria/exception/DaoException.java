package fr.pizzeria.exception;

/**
 * Exceptions g�n�r�es par les DAO
 * @author oleflohic
 */
public class DaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3967697898894470885L;

	public DaoException() {
		// TODO Auto-generated constructor stub
	}

	public DaoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DaoException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
