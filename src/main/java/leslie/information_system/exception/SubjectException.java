package leslie.information_system.exception;

public class SubjectException extends Exception{
    public SubjectException() {
        super();
    }

    public SubjectException(String message) {
        super(message);
    }

    public SubjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public SubjectException(Throwable cause) {
        super(cause);
    }

    protected SubjectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
