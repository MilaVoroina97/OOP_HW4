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

    public T max(Comparator<? super T> comp) throws NonComparableTypeException{
        T max = massiv[0];
        if(max instanceof Comparable){
            for(int i = 0 ; i < this.massiv.length; i++){

                if(comp.compare(massiv[i], max) > 0) max =massiv[i];
            }   
            
        }else throw new NonComparableTypeException(max.getClass().getSimpleName());

        return max;

    }

    public T min(Comparator<? super T> comp)throws NonComparableTypeException{
        T min = massiv[0];
        if(min instanceof Comparable){
            for(int i = 0 ; i < this.massiv.length; i++){

                if(comp.compare(massiv[i], min) < 0) min = massiv[i];
            }   
        }else throw new NonComparableTypeException(min.getClass().getSimpleName());

        
        return min;

    }

    // Поиск суммы элементов массива

    public T sum(){
        Summa summa = new Summa();
        T sum = massiv[0];
        for(int i = 0; i < this.massiv.length; i++){
            sum = (T) summa.apply(sum,massiv[i+1]);
        }
        return sum;

    }

    public T mult(){
        Mult multClass = new Mult();
        T mult = massiv[0];
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

    public boolean findElem(T elem){

        for(T t : massiv){
            if(t == elem) return true;
        }

        return false;

    }

    // Пузырьковая сортировка

    public void bubleSort(Comparator<? super T> comp) throws NonComparableTypeException{

        T temp = this.massiv[0];
        if(temp instanceof Comparable){
            for(int i = 0; i < this.massiv.length - 1; i++){            

                boolean swapped = false;

                for(int j = 0 ; j < this.massiv.length-i-1;i++){
                    if(comp.compare(this.massiv[j],this.massiv[j+1])> 0){
                        swap(j,j+1);
                        swapped = true;
                    }
                }

                if(!swapped) break;
            }
        } else throw new NonComparableTypeException(temp.getClass().getSimpleName());
    }

    // Сортировка простыми вставками

    public void insertSort(Comparator<? super T> comp) throws NonComparableTypeException{
        T temp = this.massiv[0];
        if(temp instanceof Comparable){
            for(int i = 1; i < this.massiv.length;i++){
                for(int j = i; j > 0; j--){
                    if(comp.compare(this.massiv[j], this.massiv[j-1])<0){
                        swap(j,j-1);
                    }else {
                        break;
                    }
                }
            }
        } else throw new NonComparableTypeException(temp.getClass().getSimpleName());

    }

    // Сортировка простым выбором

    public void selectSort(Comparator<? super T> comp) throws NonComparableTypeException{

        T temp = this.massiv[0];
        if(temp instanceof Comparable){

            for(int i = 0; i < this.massiv.length; i++){
                temp = this.massiv[i];
                int minIndex = i;
                for(int j = i; j < this.massiv.length;j++){
                    if(comp.compare(this.massiv[j],temp)<0){

                        temp = this.massiv[j];
                        minIndex = j;

                    }
                }if(i!=minIndex){
                    swap(i, minIndex);
                }
            }

        }else throw new NonComparableTypeException(temp.getClass().getSimpleName());

    }

    // Получение элемента массива по индексу

    public T getElem(int index) throws IndexOutOfBoundsException{
        if(index < 0 || index > this.massiv.length) 
            System.out.printf("Index %d out of bounds for length %d\n", index, this.massiv.length);
        else{
            for(int i = 0; i < this.massiv.length; i++){
                if(i == index) return massiv[i];
            }
        }
        return null;
    }

    // Задание значения элементу массива с заданным индексом

    public void changeElem(int index,T newElem) throws IndexOutOfBoundsException{
        if(index < 0 || index > this.massiv.length) 
            System.out.printf("Index %d out of bounds for length %d\n", index, this.massiv.length);
        for(int i = 0; i < this.massiv.length;i++){

            if(i == index){

                this.massiv[index] = newElem;
                break;

            } 
        }

    }

    




    private void swap(int i, int j){

        T temp = this.massiv[i];
        this.massiv[i] = this.massiv[j];
        this.massiv[j] = temp;

    }



    






}
