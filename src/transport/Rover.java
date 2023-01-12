package transport;

import actions.Moveable;
import actions.Passenger;
import actors.Person;
import location.Location;
import transport.exceptions.*;
import transport.fuelType.FuelType;

import java.lang.Math;
import java.util.Arrays;
import java.util.Objects;

public class Rover implements Moveable {
    private int seatNumber = 4;
    private Location location;
    private int serialNumber;

    public Tank tank;
    public Odometer odometer;

    public Engine engine;
    private Passenger[] passengers = new Passenger[seatNumber];

    public Rover(int serialNumber, int hp, double fuelConsumption, Location location, FuelType fuelType) {
        this.serialNumber = serialNumber;
        this.location = location;
        engine = new Engine(hp, fuelConsumption, fuelType);
        tank = new Tank(100);
        odometer = new Odometer();
    }

    public Location.Pair getCoords() {
        return location.getCoords();
    }

    @Override
    public void goToLocation(Location location) {
        try {
            boolean t = false;
            for (int x = 0; x < seatNumber; x++) {
                if (passengers[x] != null) {
                    t = true;
                }
            }
            if (!t) {
                throw new NoDriverException("Водителя нет на месте");
            }

            double consumption = odometer.getDistanceDifference(getCoords(), location.getCoords()) / 100 * engine.fuelConsumption;
            if (consumption > tank.fuel) {
                throw new NotEnoughFuelException("Для данной поездки не хватает топлива");
            }

            if (tank.lastFill != engine.fuelType) {
                throw new IncompatibilityFuelException("Этот тип топлива не подходит для двигателя");
            }
            odometer.updateOdometer(this.location.getCoords(), location.getCoords());
            tank.fuel -= consumption;
            this.location = location;
            System.out.println("Rover отправляется в " + location.getTypeOfLocation().name());


            int i = 0;
            while (i < seatNumber) {
                if (passengers[i] != null) {
                    ((Person) passengers[i]).goToLocation(location);
                }
                i++;
            }
        } catch (NoDriverException | NotEnoughFuelException | IncompatibilityFuelException e) {
            e.printStackTrace();
        }
    }

    public void addPassenger(Passenger passenger) {
        int i = 0;
        try {
            while (i < seatNumber && passengers[i] != null) {
                i++;
            }
            if (i == seatNumber) {
                throw new RoverOverflowException("Превышено количество пассажиров");
            }
            passengers[i] = passenger;
        } catch (RoverOverflowException e) {
            e.printStackTrace();
        }
    }

    public void removePassanger(Passenger passenger) {
        int i = 0;
        while (passengers[i] != passenger && i < seatNumber) {
            i++;
        }
        passengers[i] = null;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return serialNumber == rover.serialNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber);
    }

    @Override
    public String toString() {
        return "Rover{" + "seatNumber=" + seatNumber + ", location=" + location + ", serialNumber=" + serialNumber + ", tank=" + tank + ", odometer=" + odometer + ", engine=" + engine + ", passengers=" + Arrays.toString(passengers) + '}';
    }

    public void tuckIn(double liters, FuelType fuelType) {
        tank.tuckIn(liters, fuelType);
    }

    public void changeTheTank(Tank tank) {
        this.tank = tank;
    }

    public double fuelGauge() {
        return tank.capacity;
    }

    public class Tank {
        private final double capacity; // вместимость
        private double fuel = 0;

        FuelType lastFill = FuelType.PETROL;

        public Tank(double capacity) {
            this.capacity = capacity;
        }

        public void tuckIn(double liters, FuelType fuelType) {
            try{
                if (liters + fuel > capacity){
                    fuel = capacity;
                    throw new TankOverflowException("Произошло переполнение бака", (fuel + liters) % capacity);
                }
                this.lastFill = fuelType;
                this.fuel = liters;
            } catch (TankOverflowException e) {
                throw new RuntimeException(e);
            }

        }


        public double getFullness() {
            return ((double) Math.round(fuel * 100)) / 100;
        }
    }


    public class Odometer {
        private double distanceTravelled = 0;

        public void updateOdometer(Location.Pair p1, Location.Pair p2) {
            distanceTravelled += getDistanceDifference(p1, p2);
        }


        public double getDistanceTravelled() {
            return (double) (Math.round(distanceTravelled * 100)) / 100;
        }

        public double getDistanceDifference(Location.Pair p1, Location.Pair p2) {

            return Math.sqrt(Math.pow((p2.getX() - p1.getX()), 2) + Math.pow((p2.getY() - p1.getY()), 2));
        }
    }

    public class Engine {
        private double hp;
        private double fuelConsumption;
        private FuelType fuelType;

        public Engine(double hp, double fuelConsumption, FuelType fuelType) {
            this.hp = hp;
            this.fuelConsumption = fuelConsumption;
            this.fuelType = fuelType;
        }
    }
}
