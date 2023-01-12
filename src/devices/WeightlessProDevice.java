package devices;

import devices.exceptions.DeviceIsBrokenException;
import devices.exceptions.NoCrystalInDeviceException;

public class WeightlessProDevice extends WeightlessDevice implements Scanning{
    public WeightlessProDevice(int serialNumber) {
        super(serialNumber);
    }

    @Override
    public void scan() {
        try {
            if (this.lunarCrystal == null) {
                throw new NoCrystalInDeviceException("Вставьте кристалл для сканирования");
            }
            if (!this.isServiceability()) {
                throw new DeviceIsBrokenException("Прибор сломан");
            }
        } catch (NoCrystalInDeviceException | DeviceIsBrokenException e) {
            e.printStackTrace();
        }
        System.out.println("Показания сканирования кристалла:");
        System.out.println("\t Цвет " + lunarCrystal.getColor() +
                "\n\t Теплопроводность " + lunarCrystal.getThermalConductivity() +
                "\n\t Плотность " + lunarCrystal.getDensity() +
                "\n\t Глубина залежи " + lunarCrystal.getDepositDepth());
    }
}
