import net.esliceu.numbers.BigNumber;
import net.esliceu.numbers.BigNumberOperator;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class BigNumberTest {


    @Test
    public void sumes() {
        BigNumber b1, b2;

        b1 = new BigNumber("0000");
        b2 = new BigNumber("543");
        assertEquals("543", b1.add(b2));

        b1 = new BigNumber("2");
        b2 = new BigNumber("02");
        assertEquals("4", b1.add(b2));

        b1 = new BigNumber("12");
        b2 = new BigNumber("34");
        assertEquals("46", b1.add(b2));

        b1 = new BigNumber("00022");
        b2 = new BigNumber("090");
        assertEquals("112", b1.add(b2));

        b1 = new BigNumber("123");
        b2 = new BigNumber("999");
        assertEquals("1122", b1.add(b2));

        b1 = new BigNumber("999");
        b2 = new BigNumber("999");
        assertEquals("1998", b1.add(b2));

        b1 = new BigNumber("567456234578945345234234456");
        b2 = new BigNumber("456235768978078934523523452345456");
        assertEquals("456236336434313513468868686579912", b1.add(b2));

        b1 = new BigNumber("342234234123423576789423422323123412341234");
        b2 = new BigNumber("3245234789789234234123784567892349789456");
        assertEquals("345479468913212811023547206891015762130690", b1.add(b2));
    }

    @Test
    public void restes() {
        BigNumber b1, b2;

        b1 = new BigNumber("60");
        b2 = new BigNumber("010");
        assertEquals("50", b1.subtract(b2));

        b1 = new BigNumber("34535233");
        b2 = new BigNumber("04533453");
        assertEquals("30001780", b1.subtract(b2));

        b1 = new BigNumber("7");
        b2 = new BigNumber("3");
        assertEquals("4", b1.subtract(b2));

        b1 = new BigNumber("14");
        b2 = new BigNumber("12");
        assertEquals("2", b1.subtract(b2));

        b1 = new BigNumber("34");
        b2 = new BigNumber("19");
        assertEquals("15", b1.subtract(b2));

        b1 = new BigNumber("32453453");
        b2 = new BigNumber("2313");
        assertEquals("32451140", b1.subtract(b2));

        b1 = new BigNumber("32456789567456786783453");
        b2 = new BigNumber("2345664556756713");
        assertEquals("32456787221792230026740", b1.subtract(b2));

        b1 = new BigNumber("56734564576346234567567834534565675674567");
        b2 = new BigNumber("999999999999999999999999999999999999999");
        assertEquals("55734564576346234567567834534565675674568", b1.subtract(b2));

        b1 = new BigNumber("45634563456565555557854564223429999886785678912");
        b2 = new BigNumber("0000000000000000000000000000000000000000000000000000000000011");
        assertEquals("45634563456565555557854564223429999886785678901", b1.subtract(b2));

        b1 = new BigNumber("45634563456565555557854564223429999886785678912");
        b2 = new BigNumber("789789797979454534534534567867823489898899");
        assertEquals("45633773666767576103320029688862132063295780013", b1.subtract(b2));

        b1 = new BigNumber("45634563456565555557854564223429999886785678912");
        b2 = new BigNumber("789789797979454534534534567867823489898899");
        assertEquals("45633773666767576103320029688862132063295780013", b1.subtract(b2));
    }

}