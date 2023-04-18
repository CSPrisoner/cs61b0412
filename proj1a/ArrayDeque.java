public class ArrayDeque<Item> {
    private Item[] items;
    private int size;
    private int capacity;
    private int nextFirst;
    private int nextLast;

    private void resize(int capacity){
        Item[] a = (Item[]) new Object[capacity];
        for (int i = 1; i <= size; i++){
            a[i] = items[(++nextFirst) % this.capacity];
        }
        this.capacity = capacity;
        items = a;
        nextLast = size + 1;
        nextFirst = 0;
    }

    public void addFirst(Item item){
        if (size == capacity)
            resize(capacity * 2);
        items[nextFirst] = item;
        nextLast = (capacity + nextFirst - 1) % capacity;
        size += 1;
    }

    public void addLast(Item item){
        if (size == capacity)
            resize(capacity * 2);
        items[nextLast] = item;
        nextLast = (nextLast + 1) % capacity;
        size += 1;
    }

    public Item removeFirst(){
        if (size == 0)
            return null;
        nextFirst = (nextFirst + 1) % capacity;
        Item x = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        if (capacity >= 16 && size < capacity / 4)
            resize(capacity / 2);
        return x;
    }

    public Item removeLast(){
        if (size == 0)
            return null;
        nextLast = (capacity + nextLast - 1) % capacity;
        Item x = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        if (capacity >= 16 && size < capacity / 4)
            resize(capacity / 2);
        return x;
    }


    public Item get(int index){
        if (index < 0 || index >= size)
            return null;
        else
            return items[(nextFirst + 1 + index) % capacity];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void printDeque(){
        if (size == 0)
            return;
        int start = (nextFirst + 1) % capacity;
        System.out.print(items[start]);
        start = (start + 1) % capacity;
        int end = (nextLast - 1 + capacity) % capacity;
        while (start != end){
            System.out.print(" " + items[start]);
            start = (start + 1) % capacity;
        }
    }

    public ArrayDeque(){
        items = (Item[]) new Object[8];
        this.capacity = items.length;
        nextFirst = capacity - 1;
        nextLast = 0;
        size = 0;
    }
}
