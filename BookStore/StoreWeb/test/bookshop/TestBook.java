package bookshop;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static bookshop.Pounds.inPounds;

public class TestBook {
    

    @Test
    public void settingPriceAsFloatRoundsOk() throws Exception {
        assertEquals("0.10", new Book().atPrice(inPounds(0.1)).getPrice().toString());
        assertEquals("1.00", new Book().atPrice(inPounds(1)).getPrice().toString());
     }

    @Test
    public void bookImageIsTilePrefixedWithBooksAndJpg() throws Exception {
        assertEquals("/book-images/stalingrad.jpg", new Book().withTitle("Stalingrad").getImage());
    }

    @Test
    public void bookImageTitleReplacesTitleSpacesWithUnderscores() throws Exception {
        assertEquals("/book-images/master_and_commander.jpg", new Book().withTitle("Master and Commander").getImage());
    }

    @Test
    public void bookImageTitleRemovesApostrophes() throws Exception {
        assertEquals("/book-images/the_french_lieutenants_woman.jpg", new Book().withTitle("The French Lieutenant's Woman").getImage());
    }

}
