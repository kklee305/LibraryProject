package ca.kklee.libraryproject.LoggerPlatform;

/**
 * Created by Keith on 30/05/2015.
 */
public class TestException extends Exception {

    public TestException(String message) {
        super(message);
    }

    public TestException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
