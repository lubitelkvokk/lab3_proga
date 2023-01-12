package devices.exceptions;

import devices.Device;

import java.io.IOException;

public class DeviceIsBrokenException extends RuntimeException {

    public DeviceIsBrokenException() {
        super();
    }

    public DeviceIsBrokenException(String s) {
        super(s);
    }

    public DeviceIsBrokenException(String s, Throwable cause){
        super(s,cause);
    }
}
