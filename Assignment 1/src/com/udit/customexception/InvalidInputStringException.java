package com.udit.customexception;

@SuppressWarnings("serial")
public class InvalidInputStringException extends Exception {
  public InvalidInputStringException(String msg) {
	super(msg);
	}
}