import java.util.Iterator;

public class SimpleArrayList implements Iterable<Object> {

    public final static int DEFAULT_SIZE  = 10;

    private int size;
    private Object[] elem;
    private int curPos = 0;

    public SimpleArrayList() {
        this(0,new Object[DEFAULT_SIZE]);
    }

    public SimpleArrayList(int size, Object[] elem) {
        this.size = size;
        this.elem = elem;
    }

    public int getSize() {
        return size;
    }

    public Object get(int idx){
        return !(outOfBounds(idx)) ? elem[idx]:null;
    }

    public int getCurPos(){
        return curPos;
    }

    private void increaseArr(){
        Object[] tmpA;
        tmpA = new Object[size + 5];
        System.arraycopy(elem, 0, tmpA, 0, elem.length);
        elem = tmpA;
    }

    private boolean outOfBounds(int idx){

        if (idx > elem.length) {
            System.out.println("Index "+ idx + " out of bounds");
            return true;
        }
        return false;
    }

    public void add(Object obj){

        if (size == elem.length) {
            increaseArr();
        }
        elem[size++] = obj;
    }

    public void add(int idx, Object obj){

        if (size == elem.length) {
            increaseArr();
        }

        if (outOfBounds(idx)){
            return;
        }

        Object tmp1 = elem[idx];

        Object tmp2;
        elem[idx] = obj;

        for (int i = ++idx; i < elem.length; i++) {
            tmp2 = elem[i];
            elem[i] = tmp1;
            tmp1 = tmp2;
        }
        size++;
    }

    public void addLast(Object obj){
        elem[size ++] = obj;
    }

    public void remove(int idx){

        if (outOfBounds(idx) || elem[idx] == null){
            return;
        }

        elem[idx] = null;
        int nextIdx = idx;
        nextIdx ++;

        for (int i = nextIdx; i <= size; i++) {
            Object nextObj = elem[i];
            elem[idx++] = nextObj;
        }
        size --;
    }

    @Override
    public String toString() {
        String result;
        result = "[";


        for (int i = 0; i < elem.length ; i++) {

            if (elem[i] != null){
                result += elem[i] + ", ";
            }
        }
        result = result.substring(0, result.length() - 2) + "]";
        return result;
    }

    @Override
    public Iterator<Object> iterator() {
        return new SALIterator();
    }

    private class SALIterator implements Iterator<Object>{

        public SALIterator() {
            curPos = 0;
        }

        @Override
        public boolean hasNext() {
            int nextPos = curPos;
            nextPos ++;
            return !(nextPos > size);
        }

        @Override
        public Object next() {
            if (hasNext()){
                return elem[curPos ++];
            }
            throw new IllegalStateException("List has no more elements.");
        }

        @Override
        public void remove() {
            if (!(size == 0)){
                elem[curPos] = null;
                size --;
            }
        }

    }
}
