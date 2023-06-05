package test;

import modele.ManagerDeQuete;
import modele.Scenario;

import org.junit.jupiter.api.Test;

import lectureEcritureFichier.LectureFichierTexte;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test de la classe ManagerDeQuete
 * @see ManagerDeQuete
 */
class ManagerDeQueteTest extends ManagerDeQuete {

    /**
     * Méthode qui permet de tester la méthode distanceEntrePos
     * @see ManagerDeQuete#distanceEntrePos(int[], int[])
     */
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

    /**
     * Méthode qui permet de tester la méthode peutCommencerQuete
     * @see ManagerDeQuete#peutCommencerQuete(ArrayList, int[])
     */
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

    /**
     * Méthode qui permet de tester la méthode niveau2
     * @see ManagerDeQuete#niveau2(int, String, String, String)
     */
    @Test
    void niveau2Test(){
        Scenario scenario = LectureFichierTexte.lecture(new File("scenarios" + File.separator + "scenario_0.txt"));
        ManagerDeQuete managerDeQuete = new ManagerDeQuete(scenario);

        assertEquals(27, managerDeQuete.niveau2(1, "efficace", "dureeTotal", "meilleur").get(0).getDureeTotal());
        assertEquals(30, managerDeQuete.niveau2(1, "efficace", "dureeTotal", "pire").get(0).getDureeTotal());
        assertEquals(36, managerDeQuete.niveau2(1, "exhaustive", "dureeTotal", "meilleur").get(0).getDureeTotal());
        assertEquals(40, managerDeQuete.niveau2(1, "exhaustive", "dureeTotal", "pire").get(0).getDureeTotal());

        assertEquals(350, managerDeQuete.niveau2(1, "efficace", "experience", "meilleur").get(0).getExperience());
        assertEquals(450, managerDeQuete.niveau2(1, "efficace", "experience", "pire").get(0).getExperience());
        assertEquals(550, managerDeQuete.niveau2(1, "exhaustive", "experience", "meilleur").get(0).getExperience());
        assertEquals(550, managerDeQuete.niveau2(1, "exhaustive", "experience", "pire").get(0).getExperience());

        assertEquals(14, managerDeQuete.niveau2(1, "efficace", "deplacement", "meilleur").get(0).getDeplacement());
        assertEquals(20, managerDeQuete.niveau2(1, "efficace", "deplacement", "pire").get(0).getDeplacement());
        assertEquals(20, managerDeQuete.niveau2(1, "exhaustive", "deplacement", "meilleur").get(0).getDeplacement());
        assertEquals(24, managerDeQuete.niveau2(1, "exhaustive", "deplacement", "pire").get(0).getDeplacement());

        assertEquals(4, managerDeQuete.niveau2(1, "efficace", "parcoursNum", "meilleur").get(0).getParcoursNum().size());
        assertEquals(4, managerDeQuete.niveau2(1, "efficace", "parcoursNum", "pire").get(0).getParcoursNum().size());
        assertEquals(5, managerDeQuete.niveau2(1, "exhaustive", "parcoursNum", "meilleur").get(0).getParcoursNum().size());
        assertEquals(5, managerDeQuete.niveau2(1, "exhaustive", "parcoursNum", "pire").get(0).getParcoursNum().size());


        scenario = LectureFichierTexte.lecture(new File("scenarios" + File.separator + "scenario_1.txt"));
        managerDeQuete = new ManagerDeQuete(scenario);

        assertEquals(34, managerDeQuete.niveau2(1, "efficace", "dureeTotal", "meilleur").get(0).getDureeTotal());
        assertEquals(40, managerDeQuete.niveau2(1, "efficace", "dureeTotal", "pire").get(0).getDureeTotal());
        assertEquals(34, managerDeQuete.niveau2(1, "exhaustive", "dureeTotal", "meilleur").get(0).getDureeTotal());
        assertEquals(40, managerDeQuete.niveau2(1, "exhaustive", "dureeTotal", "pire").get(0).getDureeTotal());

        assertEquals(450, managerDeQuete.niveau2(1, "efficace", "experience", "meilleur").get(0).getExperience());
        assertEquals(500, managerDeQuete.niveau2(1, "efficace", "experience", "pire").get(0).getExperience());
        assertEquals(500, managerDeQuete.niveau2(1, "exhaustive", "experience", "meilleur").get(0).getExperience());
        assertEquals(500, managerDeQuete.niveau2(1, "exhaustive", "experience", "pire").get(0).getExperience());

        assertEquals(17, managerDeQuete.niveau2(1, "efficace", "deplacement", "meilleur").get(0).getDeplacement());
        assertEquals(23, managerDeQuete.niveau2(1, "efficace", "deplacement", "pire").get(0).getDeplacement());
        assertEquals(17, managerDeQuete.niveau2(1, "exhaustive", "deplacement", "meilleur").get(0).getDeplacement());
        assertEquals(23, managerDeQuete.niveau2(1, "exhaustive", "deplacement", "pire").get(0).getDeplacement());

        assertEquals(5, managerDeQuete.niveau2(1, "efficace", "parcoursNum", "meilleur").get(0).getParcoursNum().size());
        assertEquals(6, managerDeQuete.niveau2(1, "efficace", "parcoursNum", "pire").get(0).getParcoursNum().size());
        assertEquals(6, managerDeQuete.niveau2(1, "exhaustive", "parcoursNum", "meilleur").get(0).getParcoursNum().size());
        assertEquals(6, managerDeQuete.niveau2(1, "exhaustive", "parcoursNum", "pire").get(0).getParcoursNum().size());


        scenario = LectureFichierTexte.lecture(new File("scenarios" + File.separator + "scenario_2.txt"));
        managerDeQuete = new ManagerDeQuete(scenario);

        assertEquals(80, managerDeQuete.niveau2(1, "efficace", "dureeTotal", "meilleur").get(0).getDureeTotal());
        assertEquals(106, managerDeQuete.niveau2(1, "efficace", "dureeTotal", "pire").get(0).getDureeTotal());
        assertEquals(91, managerDeQuete.niveau2(1, "exhaustive", "dureeTotal", "meilleur").get(0).getDureeTotal());
        assertEquals(117, managerDeQuete.niveau2(1, "exhaustive", "dureeTotal", "pire").get(0).getDureeTotal());

        assertEquals(1000, managerDeQuete.niveau2(1, "efficace", "experience", "meilleur").get(0).getExperience());
        assertEquals(1050, managerDeQuete.niveau2(1, "efficace", "experience", "pire").get(0).getExperience());
        assertEquals(1200, managerDeQuete.niveau2(1, "exhaustive", "experience", "meilleur").get(0).getExperience());
        assertEquals(1200, managerDeQuete.niveau2(1, "exhaustive", "experience", "pire").get(0).getExperience());

        assertEquals(35, managerDeQuete.niveau2(1, "efficace", "deplacement", "meilleur").get(0).getDeplacement());
        assertEquals(57, managerDeQuete.niveau2(1, "efficace", "deplacement", "pire").get(0).getDeplacement());
        assertEquals(39, managerDeQuete.niveau2(1, "exhaustive", "deplacement", "meilleur").get(0).getDeplacement());
        assertEquals(65, managerDeQuete.niveau2(1, "exhaustive", "deplacement", "pire").get(0).getDeplacement());

        assertEquals(9, managerDeQuete.niveau2(1, "efficace", "parcoursNum", "meilleur").get(0).getParcoursNum().size());
        assertEquals(9, managerDeQuete.niveau2(1, "efficace", "parcoursNum", "pire").get(0).getParcoursNum().size());
        assertEquals(10, managerDeQuete.niveau2(1, "exhaustive", "parcoursNum", "meilleur").get(0).getParcoursNum().size());
        assertEquals(10, managerDeQuete.niveau2(1, "exhaustive", "parcoursNum", "pire").get(0).getParcoursNum().size());


        scenario = LectureFichierTexte.lecture(new File("scenarios" + File.separator + "scenario_3.txt"));
        managerDeQuete = new ManagerDeQuete(scenario);

        assertEquals(53, managerDeQuete.niveau2(1, "efficace", "dureeTotal", "meilleur").get(0).getDureeTotal());
        assertEquals(72, managerDeQuete.niveau2(1, "efficace", "dureeTotal", "pire").get(0).getDureeTotal());
        assertEquals(64, managerDeQuete.niveau2(1, "exhaustive", "dureeTotal", "meilleur").get(0).getDureeTotal());
        assertEquals(74, managerDeQuete.niveau2(1, "exhaustive", "dureeTotal", "pire").get(0).getDureeTotal());

        assertEquals(650, managerDeQuete.niveau2(1, "efficace", "experience", "meilleur").get(0).getExperience());
        assertEquals(950, managerDeQuete.niveau2(1, "efficace", "experience", "pire").get(0).getExperience());
        assertEquals(950, managerDeQuete.niveau2(1, "exhaustive", "experience", "meilleur").get(0).getExperience());
        assertEquals(950, managerDeQuete.niveau2(1, "exhaustive", "experience", "pire").get(0).getExperience());

        assertEquals(26, managerDeQuete.niveau2(1, "efficace", "deplacement", "meilleur").get(0).getDeplacement());
        assertEquals(36, managerDeQuete.niveau2(1, "efficace", "deplacement", "pire").get(0).getDeplacement());
        assertEquals(28, managerDeQuete.niveau2(1, "exhaustive", "deplacement", "meilleur").get(0).getDeplacement());
        assertEquals(38, managerDeQuete.niveau2(1, "exhaustive", "deplacement", "pire").get(0).getDeplacement());

        assertEquals(6, managerDeQuete.niveau2(1, "efficace", "parcoursNum", "meilleur").get(0).getParcoursNum().size());
        assertEquals(8, managerDeQuete.niveau2(1, "efficace", "parcoursNum", "pire").get(0).getParcoursNum().size());
        assertEquals(8, managerDeQuete.niveau2(1, "exhaustive", "parcoursNum", "meilleur").get(0).getParcoursNum().size());
        assertEquals(8, managerDeQuete.niveau2(1, "exhaustive", "parcoursNum", "pire").get(0).getParcoursNum().size());


        scenario = LectureFichierTexte.lecture(new File("scenarios" + File.separator + "scenario_4.txt"));
        managerDeQuete = new ManagerDeQuete(scenario);

        assertEquals(95, managerDeQuete.niveau2(1, "efficace", "dureeTotal", "meilleur").get(0).getDureeTotal());
        assertEquals(167, managerDeQuete.niveau2(1, "efficace", "dureeTotal", "pire").get(0).getDureeTotal());
        assertEquals(115, managerDeQuete.niveau2(1, "exhaustive", "dureeTotal", "meilleur").get(0).getDureeTotal());
        assertEquals(171, managerDeQuete.niveau2(1, "exhaustive", "dureeTotal", "pire").get(0).getDureeTotal());

        assertEquals(900, managerDeQuete.niveau2(1, "efficace", "experience", "meilleur").get(0).getExperience());
        assertEquals(1100, managerDeQuete.niveau2(1, "efficace", "experience", "pire").get(0).getExperience());
        assertEquals(1100, managerDeQuete.niveau2(1, "exhaustive", "experience", "meilleur").get(0).getExperience());
        assertEquals(1100, managerDeQuete.niveau2(1, "exhaustive", "experience", "pire").get(0).getExperience());

        assertEquals(49, managerDeQuete.niveau2(1, "efficace", "deplacement", "meilleur").get(0).getDeplacement());
        assertEquals(107, managerDeQuete.niveau2(1, "efficace", "deplacement", "pire").get(0).getDeplacement());
        assertEquals(55, managerDeQuete.niveau2(1, "exhaustive", "deplacement", "meilleur").get(0).getDeplacement());
        assertEquals(111, managerDeQuete.niveau2(1, "exhaustive", "deplacement", "pire").get(0).getDeplacement());

        assertEquals(7, managerDeQuete.niveau2(1, "efficace", "parcoursNum", "meilleur").get(0).getParcoursNum().size());
        assertEquals(10, managerDeQuete.niveau2(1, "efficace", "parcoursNum", "pire").get(0).getParcoursNum().size());
        assertEquals(10, managerDeQuete.niveau2(1, "exhaustive", "parcoursNum", "meilleur").get(0).getParcoursNum().size());
        assertEquals(10, managerDeQuete.niveau2(1, "exhaustive", "parcoursNum", "pire").get(0).getParcoursNum().size());
    }
}