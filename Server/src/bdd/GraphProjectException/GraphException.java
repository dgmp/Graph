package bdd.GraphProjectException;

import javax.ejb.ApplicationException;


@ApplicationException(rollback=true)
public class GraphException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int code = 0;
	
	public GraphException(int code, String message)
	{
		super(message);
		this.setCode(code);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
