import java.util.Arrays;

public class SimpleArrayList {

    public final static int DEFAULT_SIZE  = 10;

    private int size;
    private Object[] elem;

    public SimpleArrayList() {
        this(0,new Object[DEFAULT_SIZE]);
    }

    public SimpleArrayList(int size, Object[] elem) {
        this.size = size;
        this.elem = elem;
    }

    public void add(Object obj){

        if (size == elem.length) {
            Object[] tmpA = new Object[size + 5];
            System.arraycopy(elem, 0, tmpA, 0, elem.length);
        }

        elem[size++] = obj;

    }

    public void addLast(){

    }

    public void addAfter(){

    }





}
