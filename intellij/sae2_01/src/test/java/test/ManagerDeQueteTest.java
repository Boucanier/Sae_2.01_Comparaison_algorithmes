package test;

import modele.ManagerDeQuete;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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

    @Test
    void peutCommencerQuete(){
        ArrayList<Integer> posTab = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            posTab.add(i);
        int[] preTab = {0, 0, 0, 0};
        assertTrue(peutCommencerQuete(posTab,preTab));
        preTab[0] = 1;
        assertTrue(peutCommencerQuete(posTab,preTab));
        preTab[1] = 3;
        assertTrue(peutCommencerQuete(posTab,preTab));
        preTab[1] = 0;
        preTab[2] = 2;
        assertTrue(peutCommencerQuete(posTab,preTab));
        preTab[3] = 4;
        assertTrue(peutCommencerQuete(posTab,preTab));
        preTab[3] = 0;
        preTab[1] = 3;
        assertTrue(peutCommencerQuete(posTab,preTab));
        preTab[3] = 3;
        preTab[1] = 4;
        assertTrue(peutCommencerQuete(posTab,preTab));
        preTab[0] = 5;
        preTab[1] = 0;
        preTab[2] = 0;
        preTab[3] = 0;
        assertFalse(peutCommencerQuete(posTab,preTab));
        preTab[2] = 1;
        preTab[3] = 4;
        assertFalse(peutCommencerQuete(posTab,preTab));
        preTab[0] = 6;
        preTab[1] = 5;
        preTab[2] = 0;
        preTab[3] = 0;
        assertFalse(peutCommencerQuete(posTab,preTab));
        preTab[0] = 1;
        preTab[1] = 5;
        preTab[2] = 6;
        preTab[3] = 0;
        assertFalse(peutCommencerQuete(posTab,preTab));
        preTab[0] = 5;
        preTab[1] = 0;
        assertFalse(peutCommencerQuete(posTab,preTab));
        preTab[0] = 1;
        preTab[1] = 5;
        preTab[2] = 7;
        preTab[3] = 6;
        assertFalse(peutCommencerQuete(posTab,preTab));
    }
}