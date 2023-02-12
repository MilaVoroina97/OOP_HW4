import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        List<String> str = new ArrayList<>();
        str.add("a");
        str.add("c");
        str.add("b");
        List<Integer> in = new ArrayList<>();
        in.add(1);
        in.add(2);
        in.add(3);
        int max = Math.max(in.get(0),in.get(1));
        System.out.println(Collections.max(str));
        String all = "";
        for(int i = 0; i< str.size();i++){
            all+= str.get(i);
        }

        System.out.println(all);
        String[] strings = {"I'm", "running", "out", "of", "pangrams!"};
        String myString = String.join(" ", strings);
        
    
    }
    
}
