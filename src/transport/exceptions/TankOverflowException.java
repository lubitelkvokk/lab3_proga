package transport.exceptions;

import java.io.IOException;

public class TankOverflowException extends IOException {

    private double waste;

    public TankOverflowException() {
        super();
    }

    public TankOverflowException(double waste) {
        this.waste = waste;
    }

    public TankOverflowException(String s, double waste) {
        super(s);
        this.waste = waste;
    }

    public TankOverflowException(String s, Throwable e) {
        super(s, e);
    }

    public double getWaste() {
        return waste;
    }
}
