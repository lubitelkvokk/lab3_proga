package transport.exceptions;

import java.io.IOException;

public class NoDriverException extends IOException {
    public NoDriverException() {
        super();
    }

    public NoDriverException(String s) {
        super(s);
    }

    public NoDriverException(String message, Throwable cause) {
        super(message, cause);
    }
}
