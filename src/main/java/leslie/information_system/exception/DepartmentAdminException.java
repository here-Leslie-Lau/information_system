package leslie.information_system.exception;

public class DepartmentAdminException extends Exception{
    public DepartmentAdminException() {
        super();
    }

    public DepartmentAdminException(String message) {
        super(message);
    }

    public DepartmentAdminException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentAdminException(Throwable cause) {
        super(cause);
    }

    protected DepartmentAdminException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
