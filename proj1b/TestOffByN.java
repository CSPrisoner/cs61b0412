import org.junit.Test;

public class TestOffByN {
    @Test
    public void testOffByN(){
        OffByN offBy5 = new OffByN(5);
        offBy5.equalChars('a', 'f');  // true
        offBy5.equalChars('f', 'a');  // true
        offBy5.equalChars('f', 'h');  // false
    }
}
