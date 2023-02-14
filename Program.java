import java.util.Comparator;

public class Program {

    public static void main(String[] args) {
        try{
            MyList<Integer> myList = new MyList<>();
            myList.add(2);
            myList.add(37); 
            myList.add(47);
            myList.add(27);
            myList.add(55);
            myList.add(87);
            myList.add(12);
            myList.add(51);
            myList.add(12);
            myList.add(12);
            myList.add(12);
            myList.add(88);
            myList.changeElem(1, 33);
            System.out.println(myList.findElem(2));
            myList.removeFromElem(47);
            myList.removeFromIndex(3);
            System.out.println(myList.sum());
            System.out.println(myList.findIndex(51));
            myList.printMyList();
            System.out.println();
            System.out.println(myList.mult());
            Comparator<Integer> intComparator = new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(o1, o2);
                }
            };

            System.out.println(myList.max(intComparator));
            System.out.println(myList.min(intComparator));
            myList.bubleSort(intComparator);
            myList.printMyList();
            System.out.println();
            System.out.println(myList.getElem(4));


        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
    
}
