package edu.iu.lemmizer.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.iu.lemmizer.errorcodes.ErrorCodes;
import edu.iu.lemmizer.errorcodes.ErrorMessages;

@Component
public class LemmaException extends RuntimeException
{
	@Autowired
	ErrorMessages errorMessages;

	private static final long serialVersionUID = 1L;

	String errorCode = ErrorCodes.SystemError;

	public LemmaException()
	{
		super();
	}

	public LemmaException(String errorCode)
	{
		this.errorCode = errorCode;
	}

	public LemmaException(String errorCode, String message)
	{
		super(message);
		this.errorCode = errorCode;
	}

	@Override
	public String getMessage()
	{
		String errorMessage = "Error: " + errorMessages.getErrorMessage(errorCode);
		errorMessage += " underlying error: " + super.getMessage();
		return errorMessage;
	}
}
