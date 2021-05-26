import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

        import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SILab2Test {

    private List<Time> createList(Integer... elems)
    {
        return new ArrayList<>(Arrays.asList(elems));
    }

    @Test
    public void test() {
        RuntimeException ex;

        assertEquals(0, SILab2.function(createList()));

        assertEquals(3720, SILab2.function(createList(1,1,1)));

        ex=assertThrows(RuntimeException.class, () -> SILab2.function(createList(-1,1,1)));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        ex=assertThrows(RuntimeException.class, () -> SILab2.function(createList(25,1,1)));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        ex=assertThrows(RuntimeException.class, () -> SILab2.function(createList(12,-1,1)));
        assertTrue(ex.getMessage().contains("The minutes are not valid"));

        ex=assertThrows(RuntimeException.class, () -> SILab2.function(createList(12,60,1)));
        assertTrue(ex.getMessage().contains("The minutes are not valid"));

        ex=assertThrows(RuntimeException.class, () -> SILab2.function(createList(12,30,-1)));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        ex=assertThrows(RuntimeException.class, () -> SILab2.function(createList(12,30,60)));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        assertEquals(37832, SILab2.function(createList(10,30,32)));

        ex=assertThrows(RuntimeException.class, () -> SILab2.function(createList(24,1,1)));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        ex=assertThrows(RuntimeException.class, () -> SILab2.function(createList(24,0,1)));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        assertEquals(86400, SILab2.function(createList(24,0,0)));
    }
}