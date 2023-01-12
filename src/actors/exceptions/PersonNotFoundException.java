package actors.exceptions;

import java.io.IOException;

public class PersonNotFoundException extends IOException {
    public PersonNotFoundException() {
        super();
    }

    public PersonNotFoundException(String s) {
        super(s);
    }

    public PersonNotFoundException(String s, Throwable e) {
        super(s, e);
    }
}
