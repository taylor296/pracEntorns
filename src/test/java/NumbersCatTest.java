import net.esliceu.numbers.Numbers;
import net.esliceu.numbers.NumbersCat;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumbersCatTest {

    Numbers numbers;

    @Before
    public void setUp() throws Exception {
        numbers = new NumbersCat();
    }
    
    @Test
    public void test1() {
        assertEquals("Zero", numbers.say(0));
        assertEquals("Un", numbers.say(1));
        assertEquals("Set", numbers.say(7));
        assertEquals("Vuit", numbers.say(8));
        assertEquals("Dinou", numbers.say(19));
        assertEquals("Menys quatre", numbers.say(-4));
    }

    @Test
    public void test2() {
        assertEquals("Quaranta-quatre", numbers.say(44));
        assertEquals("Cinquanta-sis", numbers.say(56));
        assertEquals("Trenta", numbers.say(30));
        assertEquals("Noranta-nou", numbers.say(99));
        assertEquals("Vint", numbers.say(20));
        assertEquals("Vint-i-set", numbers.say(27));
        assertEquals("Menys seixanta-vuit", numbers.say(-68));
    }

    @Test
    public void test3() {
        assertEquals("Cent vint-i-cinc", numbers.say(125));
        assertEquals("Menys cent", numbers.say(-100));
        assertEquals("Dos-cents tres", numbers.say(203));
        assertEquals("Quatre-cents catorze", numbers.say(414));
        assertEquals("Nou-cents noranta-nou", numbers.say(999));
        assertEquals("Cinc-cents", numbers.say(500));
    }

    @Test
    public void test4() {
        assertEquals("Mil un", numbers.say(1001));
        assertEquals("Mil", numbers.say(1000));
        assertEquals("Dos mil", numbers.say(2000));
        assertEquals("Tres mil quatre-cents cinquanta-sis", numbers.say(3456));
        assertEquals("Trenta mil cinc-cents quaranta-tres", numbers.say(30_543));
        assertEquals("Cent mil", numbers.say(100_000));
        assertEquals("Nou-cents noranta-vuit mil vuit-cents vuitanta-nou", numbers.say(998_889));
    }

    @Test
    public void test5() {
        assertEquals("Un milió dos-cents trenta-quatre mil cinc-cents seixanta-set",
                numbers.say(1_234_567));
        assertEquals("Vint-i-dos milions cinc-cents quaranta-tres mil",
                numbers.say(22_543_000));
        assertEquals("Nou-cents un milions set",
                numbers.say(901_000_007));
        assertEquals("Nou-cents nou milions nou-cents noranta-nou mil nou-cents noranta-nou",
                numbers.say(909_999_999));
        assertEquals("Mil milions",
                numbers.say(1_000_000_000));
        assertEquals("Quinze mil vint milions noranta-vuit mil cinc-cents quaranta-vuit",
                numbers.say(15_020_098_548L));
        assertEquals("Nou-cents noranta-nou mil milions cinc mil tres-cents noranta-dos",
                numbers.say(999_000_005_392L));
    }

    @Test
    public void test6() {
        assertEquals("Un bilió",
                numbers.say(1_000_000_000_000L));
        assertEquals("Mil bilions",
                numbers.say(1_000_000_000_000_000L));
        assertEquals("Cent seixanta-cinc mil quaranta-tres bilions dos-cents disset mil nou-cents vuitanta-set milions cinquanta mil cent sis",
                numbers.say(165_043_217_987_050_106L));
        assertEquals("Nou mil onze bilions sis-cents cinquanta-tres milions vint mil vuit",
                numbers.say(9_011_000_653_020_008L));
        assertEquals("Nou-cents noranta-nou mil bilions",
                numbers.say(999_000_000_000_000_000L));
    }

    @Test
    public void test7() {
        assertEquals("Un trilió",
                numbers.say(1_000_000_000_000_000_000L));
        assertEquals("Nou trilions dos-cents vint-i-tres mil tres-cents setanta-dos bilions trenta-sis mil vuit-cents cinquanta-quatre milions set-cents setanta-cinc mil vuit-cents set",
                numbers.say(9_223_372_036_854_775_807L));
    }
}