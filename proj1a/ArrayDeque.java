public class ArrayDeque<Item> {
    private Item[] items;
    private int size;

    public void resize(int capacity){
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items,0, a, 0, size);
        items = a;
    }

    public void add(Item x){
        if (size == items.length)
            resize(size + 1);
        items[size] = x;
        size += 1;
    }

    public Item remove(){
        if (size == 0)
            return null;
        Item x = items[size - 1];
        items[size - 1] = null;
        size -= 1;
        return x;
    }

    public Item get(int i){
        if (i < 0 || i >= size)
            return null;
        else
            return items[i];
    }

    public int size(){
        return size;
    }

    public ArrayDeque(){
        items = (Item[]) new Object[8];
        size = 0;
    }

    public ArrayDeque(ArrayDeque other){
        int otherSize = other.size;
        items = (Item[]) new Object[otherSize];
        size = otherSize;
        for (int i = 0; i < otherSize; i += 1){
            items[i] = (Item) other.items[i];
        }
    }

}
