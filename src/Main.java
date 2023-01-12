import actors.*;
import devices.Magnet;
import devices.WeightlessProDevice;
import items.crystals.AntiLunit;
import items.crystals.Lunit;
import items.lumbers.Lumber;
import location.Location;
import location.TypeOfLocation;
import transport.Rover;
import transport.exceptions.TankOverflowException;
import transport.fuelType.FuelType;


// Как только Винтик и Шпунтик очутились в лесу со своим вездеходом, на строительную площадку непрерывным потоком начали поступать бревна, брусья, доски, планки, рейки, штакетник и другие пиломатериалы.
// Нечего, конечно, и говорить, что вся работа на строительстве велась в условиях невесомости, что очень облегчало труд коротышек и ускоряло работу.
// Увидев, что Винтик и Шпунтик завалили пиломатериалами чуть ли не всю стройплощадку.
// Знайка велел им прекратить пока это дело и заняться починкой испорченных лунатиками приборов.
// Сам Знайка вместе с Фуксией и Селедочкой были заняты исследованием свойств лунита и антилунита.
// Заменяя в приборе невесомости кристаллы лунита, они обнаружили, что величина зоны невесомости находится в прямой зависимости от величины кристалла: чем больше был кристалл, тем больше была и зона.
// Поместив кристалл лунита между полюсами подковообразного магнита, Фуксия обнаружила, что зона невесомости перестала распространяться во все стороны, а распространяется лишь в одном направлении, на манер светового луча.


public class Main {

    public static void main(String[] args) {


        //Rover.HandleBar handleBar = rover.new HandleBar();
        Location forest = new Location(TypeOfLocation.FOREST, 53, 91);
        Location site = new Location(TypeOfLocation.CONSTRUCTION_SITE, 10, 15);
        Magnet magnet = new Magnet(234234234);


        WeightlessProDevice weightlessDevice = new WeightlessProDevice(534235516);
        Lunit lunit1 = new Lunit(25);
        lunit1.setWeightlessRay();
        Lunit lunit2 = new Lunit(35);

        Location spaceship = new Location(TypeOfLocation.SPACESHIP, 234, 25);

        Vintik vintik = new Vintik(20, "Milky Way", site);
        Shpuntik shpuntik = new Shpuntik(19, "Milky Way", site);
        Rover rover = new Rover(1324235235, 300, 20, site, FuelType.PETROL) {
            @Override
            public void changeTheTank(Tank tank) {
                System.out.println("В данной машине не предусмотрена заменя бака");
            }
        };
        Znayka znayka = new Znayka(22, "Milky Way", spaceship);
        Fuchsia fuchsia = new Fuchsia(18, "Milky Way", spaceship);
        Seledochka seledochka = new Seledochka(20, "Milky Way", spaceship);
        Lunatic lunatic = new Lunatic();


        // Как только Винтик и Шпунтик очутились в лесу со своим вездеходом,
        // на строительную площадку непрерывным потоком начали поступать бревна, брусья, доски, планки, рейки, штакетник и другие пиломатериалы.

        System.out.println(rover.fuelGauge()); // заполненность бака в литрах топлива


        weightlessDevice.setCrystal(lunit1);
        weightlessDevice.scan();

        //vintik.seatIn(rover);
        shpuntik.seatIn(rover);
        try {
            rover.tuckIn(101, FuelType.PETROL);
        } catch (RuntimeException e) {
            TankOverflowException cause = (TankOverflowException) e.getCause();
            System.out.println("Излишек составил " + cause.getWaste() + "л");
        }

        System.out.println(rover.tank.getFullness());
        rover.goToLocation(forest);
        System.out.println(rover.odometer.getDistanceTravelled());
        System.out.println(rover.tank.getFullness());
        rover.goToLocation(site);
        System.out.println(rover.odometer.getDistanceTravelled());
        System.out.println(rover.tank.getFullness());

        shpuntik.clutterSite(Lumber.LOGS, Lumber.BEAMS, Lumber.LATHS, Lumber.BEAMS, Lumber.LATHS, Lumber.BEAMS, Lumber.LATHS);

        vintik.clutterSite(Lumber.SLATS, Lumber.LATHS, Lumber.BATTENS);
        //

        // Нечего, конечно, и говорить, что вся работа на строительстве велась в условиях невесомости,
        // что очень облегчало труд коротышек и ускоряло работу.
        site.setWeightless(true);
        //

        // Увидев, что Винтик и Шпунтик завалили пиломатериалами чуть ли не всю стройплощадку.
        // Знайка велел им прекратить пока это дело и заняться починкой испорченных лунатиками приборов.
        znayka.goToLocation(site);
        System.out.println(site.searchPerson(znayka));
        znayka.seeSituationOnSite(vintik, shpuntik);

        lunatic.crashDevices(magnet, weightlessDevice);
        znayka.orderToFix(magnet, vintik, shpuntik);
        znayka.orderToFix(weightlessDevice, vintik, shpuntik);
        vintik.fixDevice(magnet);
        shpuntik.fixDevice(weightlessDevice);
        //

        // Сам Знайка вместе с Фуксией и Селедочкой были заняты исследованием свойств лунита и антилунита.
        AntiLunit antiLunit = new AntiLunit(20);
        znayka.research(lunit1);
        znayka.research(antiLunit);
        fuchsia.research(lunit1);
        fuchsia.research(antiLunit);
        seledochka.research(lunit1);
        seledochka.research(antiLunit);

        // Заменяя в приборе невесомости кристаллы лунита, они обнаружили,
        // что величина зоны невесомости находится в прямой зависимости от величины кристалла: чем больше был кристалл, тем больше была и зона.
        lunatic.crashDevices(weightlessDevice);
        znayka.setCrystal(lunit1, weightlessDevice);
        znayka.replaceCrystal(lunit2, weightlessDevice);

        // Поместив кристалл лунита между полюсами подковообразного магнита,
        // Фуксия обнаружила, что зона невесомости перестала распространяться во все стороны,
        // а распространяется лишь в одном направлении, на манер светового луча.
        fuchsia.setCrystal(lunit1, magnet);
        fuchsia.detectFeatureLunit();


//        Func func = (a, b) -> {
//            b = a + 5;
//            return (a * b);
//        };
//        Func func1 = (a, b) -> a * b;
        //             |         |
        //        конструктор   метод

    }
}