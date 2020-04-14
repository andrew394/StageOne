package test.epam.aircompany;

import com.epam.aircompany.action.PlaneAction;
import com.epam.aircompany.exception.MilitaryPlaneException;
import com.epam.aircompany.exception.PassengerPlaneException;
import com.epam.aircompany.model.ClassificationLevel;
import com.epam.aircompany.model.ExperimentalType;
import com.epam.aircompany.model.MilitaryType;
import com.epam.aircompany.plane.ExperimentalPlane;
import com.epam.aircompany.plane.MilitaryPlane;
import com.epam.aircompany.plane.PassengerPlane;
import com.epam.aircompany.plane.Plane;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class PlaneActionTest {

    private PlaneAction planeAction;
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalType.VTOL, ClassificationLevel.TOP_SECRET)
    );

    @BeforeClass
    public void setUp() {
        planeAction = new PlaneAction(planes);
    }

    @AfterClass
    public void tearDown() {
        planeAction = null;
    }

    @Test
    public void testGetTransportMilitaryPlanes() throws MilitaryPlaneException {
        List<MilitaryPlane> transportMilitaryPlanes = planeAction.getTransportMilitaryPlanes();
        boolean condition = true;
        for (MilitaryPlane militaryPlane : transportMilitaryPlanes) {
            if (militaryPlane.getMilitaryType() != MilitaryType.TRANSPORT) {
                condition = false;
            }
        }
        Assert.assertTrue(condition);
    }

    @Test(dataProvider = "getPassengerPlaneWithMaxCapacity")
    public void testGetPassengerPlaneWithMaxCapacity(List<Plane> planeList, PassengerPlane expectedPassengerPlane) throws PassengerPlaneException {
        PlaneAction planeAction = new PlaneAction(planeList);
        PassengerPlane actualPlaneWithMaxPassengersCapacity = planeAction.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(actualPlaneWithMaxPassengersCapacity, expectedPassengerPlane);
    }

    @DataProvider
    public static Object[][] getPassengerPlaneWithMaxCapacity(){
        return new Object[][]{
                {planes, new PassengerPlane("Boeing-747", 980, 16100, 70500, 242)
                },
        };
    }

    @Test
    public void testSortByMaxLoadCapacity() {
        planeAction.sortByMaxLoadCapacity();
        List<? extends Plane> planeSortedByMaxLoadCapacity = planeAction.getPlanes();
        boolean nextPlaneMaxLoadCapacityIsHigherThanCurrent = true;
        for (int i = 0; i < planeSortedByMaxLoadCapacity.size() - 1; i++) {
            Plane currentPlane = planeSortedByMaxLoadCapacity.get(i);
            Plane nextPlane = planeSortedByMaxLoadCapacity.get(i + 1);
            if (currentPlane.getMaxLoadCapacity() > nextPlane.getMaxLoadCapacity()) {
                nextPlaneMaxLoadCapacityIsHigherThanCurrent = false;
                break;
            }
        }
        Assert.assertTrue(nextPlaneMaxLoadCapacityIsHigherThanCurrent);
    }

    @Test
    public void testHasMilitaryTypeBomberInMilitaryPlanes() throws MilitaryPlaneException {
        List<MilitaryPlane> bomberMilitaryPlanes = planeAction.getBomberMilitaryPlanes();
        Assert.assertFalse(bomberMilitaryPlanes.isEmpty());
    }

    @Test
    public void testHasClassificationLevelUnclassifiedInExperimentalPlanes(){
        List<ExperimentalPlane> experimentalPlanes = planeAction.getExperimentalPlanes();
        boolean hasUnclassifiedPlane = false;
        for(ExperimentalPlane experimentalPlane : experimentalPlanes){
            if(experimentalPlane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED){
                hasUnclassifiedPlane = true;
                break;
            }
        }
        Assert.assertFalse(hasUnclassifiedPlane);
    }
}
