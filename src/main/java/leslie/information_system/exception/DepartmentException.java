package leslie.information_system.exception;

public class DepartmentException extends Exception{
    public DepartmentException() {
        super();
    }

    public DepartmentException(String message) {
        super(message);
    }

    public DepartmentException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentException(Throwable cause) {
        super(cause);
    }

    protected DepartmentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
