import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class SILab2Test {

    @Test
    public void testEveryStatement() {

        Item item1 = new Item("", 2, 100, 0);
        List<Item> items1 = List.of(item1);
        try {
            SILab2.checkCart(items1, "1234567812345678");
            fail("Expected exception for empty name");
        } catch (RuntimeException e) {
            assertEquals("Invalid item!", e.getMessage());
        }


        Item item2 = new Item("Apples", 5, 100, 0.2F);
        List<Item> items2 = List.of(item2);
        double result = SILab2.checkCart(items2, "1234567812345678");
        assertEquals(370.0, result, 0.01);
    }

    @Test
    public void testMultipleCondition() {

        Item item = new Item("Laptop", 11, 350, 0.1F);
        List<Item> items = List.of(item);

        double result = SILab2.checkCart(items, "1234567812345678");


        assertEquals(3435.0, result, 0.01);


        try {
            SILab2.checkCart(items, "1234");
            fail("Expected exception for invalid card");
        } catch (RuntimeException e) {
            assertEquals("Invalid card number!", e.getMessage());
        }


        try {
            SILab2.checkCart(items, "12345678ABCDEFGH");
            fail("Expected exception for invalid characters");
        } catch (RuntimeException e) {
            assertEquals("Invalid character in card number!", e.getMessage());
        }
    }
}
