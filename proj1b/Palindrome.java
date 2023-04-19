public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        if (word == null)
            return null;
        int len = word.length();
        LinkedListDeque<Character> L = new LinkedListDeque<>();
        for (int i = 0; i < len; i++){
            L.addLast(word.charAt(i));
        }
        return L;
    }

    public boolean isPalindrome(String word){
        int len = word.length();
        for (int i = 0, j = len - 1; i < j; i++, j--){
            if (word.charAt(i) != word.charAt(j))
                return false;
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        if (word == null)
            return true;
        int len = word.length();
        for (int i = 0, j = len - 1; i < j; i++, j--){
            if (!cc.equalChars(word.charAt(i), word.charAt(j)))
                return false;
        }
        return true;
    }
}
