public class OffByN implements CharacterComparator{
    int dif;

    @Override
    public boolean equalChars(char x, char y) {
        return (x - y) == dif || (x - y) == -1 * dif;
    }

    public OffByN(int i){
        dif = i;
    }
}
