package bookshop;

import org.junit.Test;
import static org.junit.Assert.*;
import static bookshop.Pounds.inPounds;

public class TestPounds {

    @Test
    public void shouldBeAbleToConstructFromADoubleWithoutFloatingPointRoundingIssues() throws Exception {
        
        assertEquals("0.10", inPounds(0.1).toString());
        assertEquals("2.51", inPounds(2.5111).toString());
    }

    @Test
    public void shouldEqualOtherOfSameValue() throws Exception {
        assertEquals(inPounds(15.56), inPounds(15.56));
        assertEquals(inPounds(20), inPounds(20.00));
        assertEquals(inPounds(.1), inPounds(.10));
    }

    @Test
    public void adding() throws Exception {
        assertEquals(inPounds(9), inPounds(4).plus(inPounds(5)));
    }


}
