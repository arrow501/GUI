import java.util.Arrays;

@FunctionalInterface
interface Transform<T, R> {
    R apply(T arg);
}

class StrToInt implements Transform<String, Integer> {
    public Integer apply(String arg) {
        return arg.length();
    }
}

public class TransformTest{

    private static <T, R>
    void transform(T[] in, R[] out, Transform<T, R> trans) {
        for (int i = 0; i < in.length; i++) {
            out[i] = trans.apply(in[i]);
        }
    }

    public static void main(String[] args) {

        String[] names = {"Alice", "Sue", "Janet", "Bea"};
        System.out.println(Arrays.toString(names) + '\n');

        Integer[] intOut = new Integer[names.length];
        transform(names, intOut, new StrToInt());
        System.out.println(Arrays.toString(intOut));

        Character[] charOut = new Character[names.length];
        transform(names, charOut, s -> s.charAt(0));
        System.out.println(Arrays.toString(charOut));

        String[] stringOut = new String[names.length];
        transform(names, stringOut, s -> s.toUpperCase());
        System.out.println(Arrays.toString(stringOut));
    }
}