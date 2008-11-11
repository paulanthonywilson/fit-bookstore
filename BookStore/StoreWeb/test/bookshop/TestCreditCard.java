package bookshop;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestCreditCard {
    @Test
    public void maskedNumberIsLastFourDigitsOfCreditCardWithOtherNumbersReplacedByX() throws Exception {
        CreditCard testee = new CreditCard();
        testee.setNumber("6543210987654321");
        assertEquals("XXXXXXXXXXXX4321", testee.getMaskedNumber());
    }

    @Test
    public void maskedNumberEmptyIfCreditCardNumberNotWellFormed() throws Exception {
        CreditCard testee = new CreditCard();
        assertEquals("", testee.getMaskedNumber());
        testee.setNumber("a");
        assertEquals("", testee.getMaskedNumber());

    }


}
