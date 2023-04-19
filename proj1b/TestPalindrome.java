import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome(){
        String word1 = "abcdcba";
        assertTrue(palindrome.isPalindrome(word1));

        String word2 = "abcd";
        assertFalse(palindrome.isPalindrome(word2));
    }

    @Test
    public void testIsPalindrome_2(){
        Deque<Character> L1= new LinkedListDeque<>();
        L1.addLast('a');
        L1.addLast('b');
        L1.addLast('a');
        assertTrue(palindrome.isPalindrome(L1));

        Deque<Character> L2= new LinkedListDeque<>();
        L2.addLast('a');
        L2.addLast('b');
        assertFalse(palindrome.isPalindrome(L2));

    }

    @Test
    public void testisPalindromecc() {
        OffByOne obo = new OffByOne();
        assertTrue(palindrome.isPalindrome("", obo));
        assertTrue(palindrome.isPalindrome("a", obo));
        assertTrue(palindrome.isPalindrome("flake", obo));
        assertTrue(palindrome.isPalindrome("zyzy", obo));
        assertTrue(palindrome.isPalindrome("yyxz", obo));
        assertTrue(palindrome.isPalindrome("yyyxz", obo));
        assertFalse(palindrome.isPalindrome("aa", obo));
        assertFalse(palindrome.isPalindrome("xyz", obo));
        assertFalse(palindrome.isPalindrome("aa", obo));
        assertFalse(palindrome.isPalindrome("zxzx", obo));
    }
}
