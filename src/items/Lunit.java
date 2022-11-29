package items;

public class Lunit extends LunarCrystal {
    public Lunit(double size) {
        super(size);
    }

    public void setWeightlessRay() {
        System.out.println("Lunit распространяет невесомость на манер светового луча с углом " + size * 0.3 + "");
    }

    public void setWeightlessZone() {
        System.out.println("Lunit распространяет зону невесомости на " + size * 70 + " м^2");
    }


}
