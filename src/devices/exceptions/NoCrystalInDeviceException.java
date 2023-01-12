package devices.exceptions;

import java.io.IOException;

public class NoCrystalInDeviceException extends IOException {
    public NoCrystalInDeviceException() {
        super();
    }

    public NoCrystalInDeviceException(String s) {
        super(s);
    }

    public NoCrystalInDeviceException(String s, Throwable cause) {
        super(s, cause);
    }
}
