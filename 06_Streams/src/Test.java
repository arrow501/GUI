
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        String file = "slowa.txt";
        for (Map.Entry<String, Integer> e : new Slowa(file))
            System.out.println(e.getKey() + " -> " + e.getValue());
               
    }

}

