package com.indorse.assigment.friend.book.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception class for error message handling .
 * 
 * @author nosheen
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FriendBookException extends RuntimeException {

	private static final long serialVersionUID = -4322049189049711910L;

	/**
	 * Instantiates a new friend book exception.
	 *
	 * @param message the message
	 */
	public FriendBookException(String message) {
		super(message);
	}

}
