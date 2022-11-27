import actors.*;
import devices.Device;
import devices.Magnet;
import devices.WeightlessDevice;
import items.AntiLunit;
import items.Lumber;
import items.Lunit;
import location.ConstructionSite;
import location.Forest;
import location.Spaceship;
import transport.Rover;


// Как только Винтик и Шпунтик очутились в лесу со своим вездеходом, на строительную площадку непрерывным потоком начали поступать бревна, брусья, доски, планки, рейки, штакетник и другие пиломатериалы.
// Нечего, конечно, и говорить, что вся работа на строительстве велась в условиях невесомости, что очень облегчало труд коротышек и ускоряло работу.
// Увидев, что Винтик и Шпунтик завалили пиломатериалами чуть ли не всю стройплощадку.
// Знайка велел им прекратить пока это дело и заняться починкой испорченных лунатиками приборов.
// Сам Знайка вместе с Фуксией и Селедочкой были заняты исследованием свойств лунита и антилунита.
// Заменяя в приборе невесомости кристаллы лунита, они обнаружили, что величина зоны невесомости находится в прямой зависимости от величины кристалла: чем больше был кристалл, тем больше была и зона.
// Поместив кристалл лунита между полюсами подковообразного магнита, Фуксия обнаружила, что зона невесомости перестала распространяться во все стороны, а распространяется лишь в одном направлении, на манер светового луча.


public class Main {
    public static void main(String[] args) {

        Rover rover = new Rover();
        Forest forest = new Forest();
        ConstructionSite site = new ConstructionSite();
        Magnet magnet = new Magnet();
        WeightlessDevice weightlessDevice = new WeightlessDevice();
        Lunit lunit1 = new Lunit(25);
        Lunit lunit2 = new Lunit(35);
        AntiLunit antiLunit = new AntiLunit(20);
        Spaceship spaceship = new Spaceship();





        Vintik vintik = new Vintik(site);
        Shpuntik shpuntik = new Shpuntik(site);
        Znayka znayka = new Znayka(spaceship);
        Fuchsia fuchsia = new Fuchsia(spaceship);
        Seledochka seledochka = new Seledochka(spaceship);




        // Как только Винтик и Шпунтик очутились в лесу со своим вездеходом,
        // на строительную площадку непрерывным потоком начали поступать бревна, брусья, доски, планки, рейки, штакетник и другие пиломатериалы.
        vintik.seatIn(rover);
        shpuntik.seatIn(rover);
        rover.goToLocation(forest);
        rover.goToLocation(site);
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
        znayka.seeSituationOnSite(vintik, shpuntik);
        znayka.orderToStop(vintik, shpuntik);
        znayka.orderToFix(magnet, vintik, shpuntik);
        //

        // Сам Знайка вместе с Фуксией и Селедочкой были заняты исследованием свойств лунита и антилунита.
        znayka.research(lunit1);
        znayka.research(antiLunit);
        fuchsia.research(lunit1);
        fuchsia.research(antiLunit);
        seledochka.research(lunit1);
        seledochka.research(antiLunit);

        // Заменяя в приборе невесомости кристаллы лунита, они обнаружили,
        // что величина зоны невесомости находится в прямой зависимости от величины кристалла: чем больше был кристалл, тем больше была и зона.

        znayka.setCrystal(lunit1, weightlessDevice);
        znayka.setCrystal(lunit2, weightlessDevice);
        znayka.detectCrystalDependence(lunit2);
        seledochka.detectCrystalDependence(lunit2);
        fuchsia.detectCrystalDependence(lunit2);

        fuchsia.setCrystal(lunit1, magnet);
        fuchsia.detectFeatureLunit();
    }
}