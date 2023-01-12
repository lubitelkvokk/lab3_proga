package transport.exceptions;

import java.io.IOException;

public class IncompatibilityFuelException extends IOException {
    public IncompatibilityFuelException() {
        super();
    }

    public IncompatibilityFuelException(String s) {
        super(s);
    }

    public IncompatibilityFuelException(String message, Throwable cause) {
        super(message, cause);
    }
}
