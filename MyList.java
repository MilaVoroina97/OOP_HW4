import java.util.Comparator;

public class MyList<T>{

    private int size;
    private T[] massiv;

    public MyList(){
        this.size = 0;
        this.massiv = (T[]) new Object[1];

    }

    public MyList(T[] massiv){

        this.size = massiv.length;
        this.massiv = massiv;

    }
    

    // Insert into massiv

    public void add(T elem){
        if(this.size == this.massiv.length) addSize();
        this.massiv[this.size + 1] = elem;

    }

    public void addSize(){
        int newSize = this.massiv.length + 1;
        T[] newMassiv = (T[]) new Object[newSize];
        for(int i = 0; i < this.massiv.length; i++){
            newMassiv[i] = this.massiv[i];
        }

        this.massiv = newMassiv;
    }

    //  Удаление элемента по индексу

    public void removeFromIndex(int index) throws IndexOutOfBoundsException{
        if(index < 0 || index > this.massiv.length) 
            System.out.printf("Index %d out of bounds for length %d\n", index, this.massiv.length);
        else{

            int newSize  = this.massiv.length - 1;
            T[] newMassiv = (T[]) new Object[newSize];
            for(int i =0 , j = 0; i < this.massiv.length; i++){

                if(i == index) continue;
                newMassiv[j++] = this.massiv[i];

            }
            this.massiv =newMassiv;
            this.size--;
        }
    }

    // Удаление всех элементов с заданным значением

    public void removeFromElem(T elem){
        for(int i = 0; i < this.massiv.length; i++){
            if(this.massiv[i] == elem){
                removeFromIndex(i);
                i--;
            }
        }
    }

    // Поиск минимума

    // public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll) {
    //     Iterator<? extends T> i = coll.iterator();
    //     T candidate = i.next();

    //     while (i.hasNext()) {
    //         T next = i.next();
    //         if (next.compareTo(candidate) > 0)
    //             candidate = next;
    //     }
    //     return candidate;
    // }


    public T max(Comparator<? super T> comp){
        T max = massiv[0];
        for(int i = 0 ; i < this.massiv.length; i++){

            if(comp.compare(massiv[i], max) > 0) max =massiv[i];
        }   
        
        return max;

    }

    public T min(Comparator<? super T> comp){
        T min = massiv[0];
        for(int i = 0 ; i < this.massiv.length; i++){

            if(comp.compare(massiv[i], min) < 0) min = massiv[i];
        }   
        
        return min;

    }

    // Поиск суммы элементов массива

    public T sum(){
        Summa summa = new Summa();
        T sum = null;
        for(int i = 0; i < this.massiv.length; i++){
            sum = (T) summa.apply(sum,massiv[i+1]);
        }
        return sum;

    }

    public T mult(){
        Mult multClass = new Mult();
        T mult = null;
        for(int i = 0; i < this.massiv.length; i++){
            mult = (T) multClass.apply(mult,massiv[i]);
        }
        return mult;
    }

    // Поиск индекса заданного элемента в массиве, если такого элемента в массиве нет то возвращать -1


    public int findIndex(T elem){

        for(int i = 0; i < this.massiv.length; i++){
            if(this.massiv[i] == elem) return i;
        }

        return -1;
    }

    // Проверка наличия элемента в массиве. Возвращает true, если элемент в массиве есть, false – нет.

    

    






}
