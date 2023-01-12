package location.exceptions;

public class LocationOverflowException extends RuntimeException {

    public LocationOverflowException() {
        super();
    }

    public LocationOverflowException(String s) {
        super(s);
    }

    public LocationOverflowException(String s, Throwable e) {
        super(s, e);
    }
}
