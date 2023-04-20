import org.junit.Test;
import static org.junit.Assert.*;

public class FlikTest {
    @Test
    public void flikTest(){
        assertTrue(Flik.isSameNumber(5,5));
        assertFalse(Flik.isSameNumber(3,4));
    }

}
