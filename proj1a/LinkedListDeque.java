public class LinkedListDeque<T> {

    private class LNode{
        T item;
        LNode pre, next;
        public LNode(T i, LNode p, LNode n){
            item = i;
            pre = p;
            next = n;
        }
    }

    private LNode sentinel;
    private int size;

    public void addFirst(T item){
        /*Adds an item of type T to the front of the deque.*/
        LNode tmp = new LNode(item, sentinel, sentinel.next);
        sentinel.next.pre = tmp;
        sentinel.next = tmp;
        size += 1;
    }

    public void addLast(T item){
        /*Adds an item of type T to the back of the deque.*/
        LNode tmp = new LNode(item,sentinel.pre, sentinel);
        sentinel.pre.next = tmp;
        sentinel.pre = tmp;
        size += 1;
    }

    public boolean isEmpty(){
        /*Returns true if deque is empty, false otherwise.*/
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        /* Prints the items in the deque from first to last,separated by a space.
        Once all the items have been printed, print out a new line.*/
        LNode p = sentinel.next;
        if (p != sentinel){
            System.out.print(p.item);
            p = p.next;
        }
        while (p != sentinel){
            System.out.print(" " + p.item);
            p = p.next;
        }
    }

    public T removeFirst(){
        /*Removes and returns the item at the front of the deque.
        If no such item exists, returns null.*/
        if (isEmpty())
            return null;
        T res = sentinel.next.item;
        sentinel.next.next.pre = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return res;
    }

    public T removeLast(){
        /*Removes and returns the item at the back of the deque.
        If no such item exists, returns null.*/
        if (isEmpty())
            return null;
        T res = sentinel.pre.item;
        sentinel.pre.pre.next = sentinel;
        sentinel.pre = sentinel.pre.pre;
        size -= 1;
        return res;
    }

    public T get(int index){
        /* Gets the item at the given index, where 0 is the front,
        1 is the next item, and so forth. If no such item exists,
        returns null. Must not alter the deque!*/
        if (index < 0 || index >= size)
            return null;
        LNode tmp = sentinel.next;
        int seq_num = 0;
        while (seq_num < index){
            tmp = tmp.next;
            seq_num += 1;
        }
        return tmp.item;
    }

    public T getRecursive(int index){
        if (index < 0 || index >= size)
            return null;
        else
            return help_getRecursive(index, sentinel.next);
    }

    private T help_getRecursive(int index, LNode p){
        if (index == 0)
            return p.item;
        else
            return help_getRecursive(index-1, p.next);
    }

    public LinkedListDeque(){
        sentinel = new LNode(null, null, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }
}
