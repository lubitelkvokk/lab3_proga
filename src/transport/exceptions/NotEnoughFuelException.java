package transport.exceptions;

import java.io.IOException;

public class NotEnoughFuelException extends IOException {
    public NotEnoughFuelException(){
        super();
    }
    public NotEnoughFuelException(String s){
        super(s);
    }
    public NotEnoughFuelException(String message, Throwable cause) {
        super(message, cause);
    }

}
