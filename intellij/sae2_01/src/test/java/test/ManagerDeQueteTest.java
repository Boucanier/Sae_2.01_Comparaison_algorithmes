package test;

import modele.ManagerDeQuete;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerDeQueteTest extends ManagerDeQuete {

    @Test
    void distanceEntrePosTest(){
        int[] posTab1 = {2,3};
        int[] posTab2 = {2,3};
        assertEquals(0, distanceEntrePos(posTab1,posTab2));
        posTab2[0] = 5;
        assertEquals(3, distanceEntrePos(posTab1,posTab2));
        posTab2[1] = 1;
        assertEquals(5, distanceEntrePos(posTab1,posTab2));
        posTab2[1] = 5;
        assertEquals(5, distanceEntrePos(posTab1,posTab2));
        posTab1[0] = 4;
        posTab1[1] = 3;
        posTab2[0] = 2;
        posTab2[1] = 3;
        assertEquals(2, distanceEntrePos(posTab1,posTab2));
        posTab1[1] = 5;
        assertEquals(4, distanceEntrePos(posTab1,posTab2));
        posTab1[0] = 3;
        posTab1[1] = 4;
        posTab2[0] = 0;
        posTab2[1] = 0;
        assertEquals(7, distanceEntrePos(posTab1,posTab2));
        posTab2[0] = 3;
        posTab2[1] = 3;
        assertEquals(1, distanceEntrePos(posTab1,posTab2));
        posTab2[1] = 6;
        assertEquals(2, distanceEntrePos(posTab1,posTab2));
    }
}