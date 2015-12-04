import java.util.Iterator;

public class Demo {

    public static void main(String[] args) {

        SimpleArrayList sal = new SimpleArrayList();
        for (int i = 0; i < 10 ; i++) {
            sal.add(i);
        }

        sal.add(34);
    //    System.out.println("1."+sal.toString());

        sal.add(21,"78");
  //      System.out.println("2."+sal.toString());

        sal.add(3,"789");
 //       System.out.println("3."+sal.toString());

        sal.addLast(67);
//        System.out.println("4."+sal.toString());

        sal.addLast(99);
 //       System.out.println("5."+sal.toString());

        sal.remove(2);
 //       System.out.println("6."+sal.toString());

        String result = "[";

        for (Object obj:sal) {
            result += obj + ", ";
        }
        result = result.substring(0,result.length() - 2) + "]";
        System.out.println(result);


        for (int i = 0; i < sal.getSize(); i++){
            System.out.print(sal.get(i)+". ");
        }

        System.out.println();

        for (Iterator<Object> it = sal.iterator(); it.hasNext();){
            it.remove();
            it.next();

        }

        System.out.println(sal.toString());



    }


}
