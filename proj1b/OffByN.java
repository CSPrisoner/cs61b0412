public class OffByN implements CharacterComparator{
    private int dif;

    @Override
    public boolean equalChars(char x, char y) {
        return (x - y) == dif || (x - y) == -1 * dif;
    }

    public OffByN(int i){
        dif = i;
    }
}
