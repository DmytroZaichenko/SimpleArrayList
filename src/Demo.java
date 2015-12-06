import java.util.Iterator;

public class Demo {

    public static void main(String[] args) {

        SimpleArrayList sal = new SimpleArrayList();
        for (int i = 0; i < 10 ; i++) {
            sal.add(i);
        }

        sal.add(34);
        sal.add(21,"78");
        sal.add(3,"789");
        sal.addLast(67);
        sal.addLast(99);

        System.out.println("before remove: ");
        System.out.println(sal.toString());
        sal.remove(2);
        System.out.println("after remove from index 2: " );
        System.out.println(sal.toString());

        System.out.println("before remove by iterator");
        System.out.println(sal.toString());

        for (Iterator<Object> it = sal.iterator(); it.hasNext();){
            it.next();
            it.remove();
        }

        System.out.println("after remove by iterator: ");
        System.out.println(sal.toString());

    }


}
