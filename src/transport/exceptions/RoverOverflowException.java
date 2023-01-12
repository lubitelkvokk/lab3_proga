package transport.exceptions;

import java.io.IOException;

public class RoverOverflowException extends RuntimeException {
    public RoverOverflowException(){
        super();
    }
    public RoverOverflowException(String s){
        super(s);
    }

    public RoverOverflowException(String message, Throwable cause) {
        super(message, cause);
    }
}
