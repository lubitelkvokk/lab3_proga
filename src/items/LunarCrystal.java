package items;

import java.util.Objects;

public class LunarCrystal {
    protected double size;

    public LunarCrystal(double size) {
        this.size = size;
    }

    public double getSize(){
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LunarCrystal that = (LunarCrystal) o;
        return Double.compare(that.size, size) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }


    @Override
    public String toString() {
        return "CrystalType: " + this.getClass().getSimpleName()
                + "\n\tsize: " + size;
    }


}
