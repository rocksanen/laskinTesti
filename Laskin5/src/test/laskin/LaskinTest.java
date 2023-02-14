import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
/*
 * JUnit 5
 */

public class LaskinTest {
    private final Laskin laskin = new Laskin();
    private final double DELTA = 0.001;

    @BeforeEach
    public void clearCalculator() {
        laskin.nollaa();
    }
    @Test
    @DisplayName("Testaa yhteenlasku 3 + 3")
    public void testLisaa() {
        laskin.lisaa(3);
        laskin.lisaa(3);
        assertEquals(6, laskin.annaTulos(),DELTA, "Lukujen 3 ja 3 summa väärin");
    }

    @Test
    @DisplayName("Testaa erotus 5 - 4")
    public void testVahenna() {
        laskin.lisaa(5);
        laskin.vahenna(4);
        assertEquals(1, laskin.annaTulos(),DELTA, "Lukujen 5 ja 4 erotus väärin");
    }

    @Test
    @DisplayName("Testaa nollallajako")
    public void testJaaNollalla() {
        ArithmeticException poikkeus = assertThrows(ArithmeticException.class, () -> laskin.jaa(0));
        assertEquals("Nollalla ei voi jakaa", poikkeus.getMessage());
    }

    @Test
    @DisplayName("Testaa jakolasku 2 / 2")
    public void testJaa() {
        laskin.lisaa(2);
        laskin.jaa(2);
        assertEquals(1, laskin.annaTulos(),DELTA, "Jakolasku 2/2 väärin");
    }



}
