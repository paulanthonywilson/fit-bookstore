package bookshop;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestPounds {

    @Test
    public void shouldBeAbleToConstructFromADoubleWithoutFloatingPointRoundingIssues() throws Exception {
        
        assertEquals("0.10", Pounds.inPounds(0.1).toString());
        assertEquals("2.51", Pounds.inPounds(2.5111).toString());
    }

}
