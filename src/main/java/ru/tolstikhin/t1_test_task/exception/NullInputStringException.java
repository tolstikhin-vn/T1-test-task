package ru.tolstikhin.testtaskt1.exception;

public class NullInputStringException extends RuntimeException {
    public NullInputStringException(String message) {
        super(message);
    }
}